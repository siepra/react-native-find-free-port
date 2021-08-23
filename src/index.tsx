import { NativeModules } from 'react-native';

type FindFreePortType = {
  getFirstStartingFrom(port: number): Promise<number>;
};

const { FindFreePort } = NativeModules;

export default FindFreePort as FindFreePortType;
