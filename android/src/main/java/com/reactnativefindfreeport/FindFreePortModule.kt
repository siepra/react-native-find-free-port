package com.reactnativefindfreeport

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

import java.net.ConnectException
import java.net.InetSocketAddress
import java.net.Socket

class FindFreePortModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "FindFreePort"
    }

    @ReactMethod
    fun getFirstStartingFrom(port: Int, promise: Promise) {
      promise.resolve(checkPort(port))
    }

    fun checkPort(port: Int): Int {
      var isPortUsed = true
      var _port = port
      while (isPortUsed) {
          isPortUsed = isPortOpen("127.0.0.1", _port, 500)
          if (isPortUsed) {
              _port++
          }
      }
      return _port
    }

    private fun isPortOpen(ip: String?, port: Int, timeout: Int): Boolean {
      return try {
          val socket = Socket()
          socket.connect(InetSocketAddress(ip, port), timeout)
          socket.close()
          true
      } catch (ce: ConnectException) {
          false
      } catch (ex: java.lang.Exception) {
          false
      }
    }
    
}
