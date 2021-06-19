package nccu.blockchain.Web3jTest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class InsuranceContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060018054600160a060020a03191633179055610e4d806100326000396000f30060806040526004361061008d5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166303b37903811461009257806318769d4614610139578063209784fc1461016a57806354a0db0e1461019f5780637db3975c14610238578063b5a4d82d1461026e578063dec1c90414610292578063e08b70ae146102b3575b600080fd5b34801561009e57600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610137958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506103619650505050505050565b005b34801561014557600080fd5b5061014e610511565b60408051600160a060020a039092168252519081900360200190f35b34801561017657600080fd5b5061018b600160a060020a0360043516610521565b604080519115158252519081900360200190f35b3480156101ab57600080fd5b506101c3600160a060020a0360043516602435610542565b6040805160208082528351818301528351919283929083019185019080838360005b838110156101fd5781810151838201526020016101e5565b50505050905090810190601f16801561022a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561024457600080fd5b5061025c600160a060020a0360043516602435610767565b60408051918252519081900360200190f35b34801561027a57600080fd5b5061025c600160a060020a0360043516602435610907565b34801561029e57600080fd5b50610137600160a060020a0360043516610aa7565b3480156102bf57600080fd5b5060408051602060046024803582810135601f810185900485028601850190965285855261025c958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a999881019791965091820194509250829150840183828082843750949750508435955050506020909201359150610b389050565b600054600160a060020a031633146103c3576040805160e560020a62461bcd02815260206004820152601960248201527f6f6e6c7920686f73706974616c2063616e20646f207468697300000000000000604482015290519081900360640190fd5b6103cc83610521565b15610421576040805160e560020a62461bcd02815260206004820152601a60248201527f70617469656e74206461746120616c7265616479206578697374000000000000604482015290519081900360640190fd5b600160a060020a0383166000908152600260209081526040909120835161044a92850190610d37565b50600160a060020a0383166000908152600260209081526040909120825161047a92600190920191840190610d37565b50600160a060020a0383166000818152600260208181526040808420928301939093556004909101805460ff1916600117905581517f696e7350617469656e74000000000000000000000000000000000000000000008152825190819003600a01812093815291517fddf20d3c0d812642f34ae35bf175fed561c5ac95cac8220b274a25648cea121f9281900390910190a2505050565b600054600160a060020a03165b90565b600160a060020a031660009081526002602052604090206004015460ff1690565b600054606090600160a060020a03163314806105685750600154600160a060020a031633145b15156105e4576040805160e560020a62461bcd02815260206004820152602b60248201527f6f6e6c7920686f73706974616c20616e6420696e737572616e6365436f72702060448201527f63616e20646f2074686973000000000000000000000000000000000000000000606482015290519081900360840190fd5b6105ed83610521565b1515610631576040805160e560020a62461bcd0281526020600482015260166024820152600080516020610e02833981519152604482015290519081900360640190fd5b600160a060020a038316600090815260026020908152604080832085845260030190915290206004015460ff1615156106b4576040805160e560020a62461bcd02815260206004820152601860248201527f6d65646963616c207265636f7264206e6f742065786973740000000000000000604482015290519081900360640190fd5b600160a060020a0383166000908152600260208181526040808420868552600301825292839020805484516001821615610100026000190190911693909304601f810183900483028401830190945283835291929083018282801561075a5780601f1061072f5761010080835404028352916020019161075a565b820191906000526020600020905b81548152906001019060200180831161073d57829003601f168201915b5050505050905092915050565b60008054600160a060020a031633148061078b5750600154600160a060020a031633145b1515610807576040805160e560020a62461bcd02815260206004820152602b60248201527f6f6e6c7920686f73706974616c20616e6420696e737572616e6365436f72702060448201527f63616e20646f2074686973000000000000000000000000000000000000000000606482015290519081900360840190fd5b61081083610521565b1515610854576040805160e560020a62461bcd0281526020600482015260166024820152600080516020610e02833981519152604482015290519081900360640190fd5b600160a060020a038316600090815260026020908152604080832085845260030190915290206004015460ff1615156108d7576040805160e560020a62461bcd02815260206004820152601860248201527f6d65646963616c207265636f7264206e6f742065786973740000000000000000604482015290519081900360640190fd5b50600160a060020a0382166000908152600260208181526040808420858552600301909152909120015492915050565b60008054600160a060020a031633148061092b5750600154600160a060020a031633145b15156109a7576040805160e560020a62461bcd02815260206004820152602b60248201527f6f6e6c7920686f73706974616c20616e6420696e737572616e6365436f72702060448201527f63616e20646f2074686973000000000000000000000000000000000000000000606482015290519081900360840190fd5b6109b083610521565b15156109f4576040805160e560020a62461bcd0281526020600482015260166024820152600080516020610e02833981519152604482015290519081900360640190fd5b600160a060020a038316600090815260026020908152604080832085845260030190915290206004015460ff161515610a77576040805160e560020a62461bcd02815260206004820152601860248201527f6d65646963616c207265636f7264206e6f742065786973740000000000000000604482015290519081900360640190fd5b50600160a060020a0391909116600090815260026020908152604080832093835260039384019091529020015490565b600154600160a060020a03163314610b09576040805160e560020a62461bcd02815260206004820152601e60248201527f6f6e6c7920696e737572616e6365436f72702063616e20646f20746869730000604482015290519081900360640190fd5b6000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b600080610b43610db5565b600054600160a060020a03163314610ba5576040805160e560020a62461bcd02815260206004820152601960248201527f6f6e6c7920686f73706974616c2063616e20646f207468697300000000000000604482015290519081900360640190fd5b610bae88610521565b1515610bf2576040805160e560020a62461bcd0281526020600482015260166024820152600080516020610e02833981519152604482015290519081900360640190fd5b5050600160a060020a03861660009081526002602081815260408084209283018054600190810191829055825160a0810184528b81528085018b90528084018a9052606081018990526080810191909152818652600390940183529320825180518493610c63928492910190610d37565b506020828101518051610c7c9260018501920190610d37565b50604082810151600283015560608084015160038401556080938401516004909301805493151560ff199094169390931790925580517f696e735265636f7264000000000000000000000000000000000000000000000081528151908190036009018120600160a060020a038d168252602082018790528183018a9052928101889052905191927f6c3bd9c66926b40d2c9e35b613432219eb83e7d041f6aaf36240907b98eb35ca92918290030190a2509695505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610d7857805160ff1916838001178555610da5565b82800160010185558215610da5579182015b82811115610da5578251825591602001919060010190610d8a565b50610db1929150610de7565b5090565b60a060405190810160405280606081526020016060815260200160008152602001600081526020016000151581525090565b61051e91905b80821115610db15760008155600101610ded560070617469656e742064617461206e6f7420657869737400000000000000000000a165627a7a723058200511fb3ea6b0e0082f88f4420346116d1b655f7e2f7e32e08ea1f952d8acf1b50029";

    public static final String FUNC_INSPATIENT = "insPatient";

    public static final String FUNC_GETHOSPITAL = "getHospital";

    public static final String FUNC_ISPATIENTEXIST = "isPatientExist";

    public static final String FUNC_QUERYRECORDCAUSE = "queryRecordCause";

    public static final String FUNC_QUERYRECORDDAYS = "queryRecordDays";

    public static final String FUNC_QUERYRECORDMONEY = "queryRecordMoney";

    public static final String FUNC_SETHOSPITAL = "setHospital";

    public static final String FUNC_INSRECORD = "insRecord";

    public static final Event INSPATIENTEVNT_EVENT = new Event("InsPatientEvnt", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}, new TypeReference<Address>() {}));
    ;

    public static final Event INSRECORDEVNT_EVENT = new Event("InsRecordEvnt", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    protected InsuranceContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected InsuranceContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> insPatient(String patientAddr, String name, String addr) {
        final Function function = new Function(
                FUNC_INSPATIENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(patientAddr), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getHospital() {
        final Function function = new Function(FUNC_GETHOSPITAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> isPatientExist(String patientAddr) {
        final Function function = new Function(FUNC_ISPATIENTEXIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(patientAddr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> queryRecordCause(String patientAddr, BigInteger recordID) {
        final Function function = new Function(FUNC_QUERYRECORDCAUSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(patientAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(recordID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> queryRecordDays(String patientAddr, BigInteger recordID) {
        final Function function = new Function(FUNC_QUERYRECORDDAYS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(patientAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(recordID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> queryRecordMoney(String patientAddr, BigInteger recordID) {
        final Function function = new Function(FUNC_QUERYRECORDMONEY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(patientAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(recordID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setHospital(String _hospital) {
        final Function function = new Function(
                FUNC_SETHOSPITAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_hospital)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> insRecord(String patientAddr, String symptom, String cause, BigInteger day, BigInteger money) {
        final Function function = new Function(
                FUNC_INSRECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(patientAddr), 
                new org.web3j.abi.datatypes.Utf8String(symptom), 
                new org.web3j.abi.datatypes.Utf8String(cause), 
                new org.web3j.abi.datatypes.generated.Uint256(day), 
                new org.web3j.abi.datatypes.generated.Uint256(money)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<InsuranceContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(InsuranceContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<InsuranceContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(InsuranceContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<InsPatientEvntEventResponse> getInsPatientEvntEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(INSPATIENTEVNT_EVENT, transactionReceipt);
        ArrayList<InsPatientEvntEventResponse> responses = new ArrayList<InsPatientEvntEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InsPatientEvntEventResponse typedResponse = new InsPatientEvntEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.eventType = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.patientAddr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<InsPatientEvntEventResponse> insPatientEvntEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, InsPatientEvntEventResponse>() {
            @Override
            public InsPatientEvntEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INSPATIENTEVNT_EVENT, log);
                InsPatientEvntEventResponse typedResponse = new InsPatientEvntEventResponse();
                typedResponse.log = log;
                typedResponse.eventType = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.patientAddr = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<InsPatientEvntEventResponse> insPatientEvntEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INSPATIENTEVNT_EVENT));
        return insPatientEvntEventObservable(filter);
    }

    public List<InsRecordEvntEventResponse> getInsRecordEvntEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(INSRECORDEVNT_EVENT, transactionReceipt);
        ArrayList<InsRecordEvntEventResponse> responses = new ArrayList<InsRecordEvntEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InsRecordEvntEventResponse typedResponse = new InsRecordEvntEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.eventType = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.patientAddr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.recordID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.day = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.money = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<InsRecordEvntEventResponse> insRecordEvntEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, InsRecordEvntEventResponse>() {
            @Override
            public InsRecordEvntEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INSRECORDEVNT_EVENT, log);
                InsRecordEvntEventResponse typedResponse = new InsRecordEvntEventResponse();
                typedResponse.log = log;
                typedResponse.eventType = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.patientAddr = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.recordID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.day = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.money = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<InsRecordEvntEventResponse> insRecordEvntEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INSRECORDEVNT_EVENT));
        return insRecordEvntEventObservable(filter);
    }

    public static InsuranceContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new InsuranceContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static InsuranceContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new InsuranceContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class InsPatientEvntEventResponse {
        public Log log;

        public byte[] eventType;

        public String patientAddr;
    }

    public static class InsRecordEvntEventResponse {
        public Log log;

        public byte[] eventType;

        public String patientAddr;

        public BigInteger recordID;

        public BigInteger day;

        public BigInteger money;
    }
}
