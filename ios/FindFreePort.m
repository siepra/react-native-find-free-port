#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(FindFreePort, NSObject)

RCT_EXTERN_METHOD(getFirstStartingFrom:(int)port
                 withResolver:(RCTPromiseResolveBlock)resolve
                 withRejecter:(RCTPromiseRejectBlock)reject)

@end
