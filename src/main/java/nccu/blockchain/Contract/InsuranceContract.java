package nccu.blockchain.Contract;

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
    private static final String BINARY = "608060405234801561001057600080fd5b5060018054600160a060020a03191633179055610759806100326000396000f30060806040526004361061006c5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166303b37903811461007157806318769d4614610118578063209784fc14610149578063dec1c9041461017e578063e08b70ae1461019f575b600080fd5b34801561007d57600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610116958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375094975061025f9650505050505050565b005b34801561012457600080fd5b5061012d6103c4565b60408051600160a060020a039092168252519081900360200190f35b34801561015557600080fd5b5061016a600160a060020a03600435166103d4565b604080519115158252519081900360200190f35b34801561018a57600080fd5b50610116600160a060020a03600435166103f5565b3480156101ab57600080fd5b5060408051602060046024803582810135601f810185900485028601850190965285855261024d958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a99988101979196509182019450925082915084018382808284375094975050843595505050602090920135915061049d9050565b60408051918252519081900360200190f35b610268836103d4565b156102d457604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601a60248201527f70617469656e74206461746120616c7265616479206578697374000000000000604482015290519081900360640190fd5b600160a060020a038316600090815260026020908152604090912083516102fd92850190610663565b50600160a060020a0383166000908152600260209081526040909120825161032d92600190920191840190610663565b50600160a060020a0383166000818152600260208181526040808420928301939093556004909101805460ff1916600117905581517f696e7350617469656e74000000000000000000000000000000000000000000008152825190819003600a01812093815291517fddf20d3c0d812642f34ae35bf175fed561c5ac95cac8220b274a25648cea121f9281900390910190a2505050565b600054600160a060020a03165b90565b600160a060020a031660009081526002602052604090206004015460ff1690565b600154600160a060020a0316331461046e57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601e60248201527f6f6e6c7920696e737572616e6365436f72702063616e20646f20746869730000604482015290519081900360640190fd5b6000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b6000806104a86106e1565b6104b1886103d4565b151561051e57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601660248201527f70617469656e742064617461206e6f7420657869737400000000000000000000604482015290519081900360640190fd5b5050600160a060020a03861660009081526002602081815260408084209283018054600190810191829055825160a0810184528b81528085018b90528084018a905260608101899052608081019190915281865260039094018352932082518051849361058f928492910190610663565b5060208281015180516105a89260018501920190610663565b50604082810151600283015560608084015160038401556080938401516004909301805493151560ff199094169390931790925580517f696e735265636f7264000000000000000000000000000000000000000000000081528151908190036009018120600160a060020a038d168252602082018790528183018a9052928101889052905191927f6c3bd9c66926b40d2c9e35b613432219eb83e7d041f6aaf36240907b98eb35ca92918290030190a2509695505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106106a457805160ff19168380011785556106d1565b828001600101855582156106d1579182015b828111156106d15782518255916020019190600101906106b6565b506106dd929150610713565b5090565b60a060405190810160405280606081526020016060815260200160008152602001600081526020016000151581525090565b6103d191905b808211156106dd57600081556001016107195600a165627a7a72305820c1f02c74e2ed243e2238539ced49e6fd5713c45c137eef9ea007f9f430a441510029";

    public static final String FUNC_INSPATIENT = "insPatient";

    public static final String FUNC_GETHOSPITAL = "getHospital";

    public static final String FUNC_ISPATIENTEXIST = "isPatientExist";

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
