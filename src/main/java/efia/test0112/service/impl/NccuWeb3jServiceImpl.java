package efia.test0112.service.impl;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Hash;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import efia.test0112.service.NccuWeb3jService;
import nccu.blockchain.Contract.InsuranceContract;
import nccu.blockchain.Contract.SimpleStorage;
import rx.Subscription;
import rx.functions.Action1;


@Service("nccuWeb3jService")
public class NccuWeb3jServiceImpl implements NccuWeb3jService{
  private final static String ganacheNode = "http://localhost:8545/";
  private final static String INSURANCECORP_PRIVATE_KEY   = 
		  "84f8490c4898728c5f0839c7cac0646ef17b4236e5acc9f32cf4eeb3c4418644";
  private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
  private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L); // L being long; capital for clarity   
  //測試合約位址
  private final static String SIMPLESTORAGE_CONTRACT_ADDRESS = 
		  "0x4d7E921f70dA4C6b573A11Cd2ECbd0d066988356";
  //醫療保險合約位址
  private final static String INSURANCE_CONTRACT_ADDRESS = 
		  "0xCfF3f74f36ad6eE8c63c8dD9F39674B9BC1967C1";
  //顯示版本
	public String printWeb3Version(Web3j web3j) {
		Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return web3ClientVersion.getWeb3ClientVersion();
	}
	//從private key對應出帳戶
	public Credentials getCredentialsFromPrivateKey(String private_key) {
		return Credentials.create(private_key);
	}
	//部署合約
	public String deploySimpleStorageContract(Web3j web3j, Credentials credentials) throws Exception {
		return SimpleStorage.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT)
                .send()
                .getContractAddress();
	}
	public String deployInsuranceContract(Web3j web3j, Credentials credentials) throws Exception {
		return InsuranceContract.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT)
                .send()
                .getContractAddress();
	}
	
	//載入醫療保險合約
	public SimpleStorage loadSimpleStorageContract(String address, Web3j web3j, Credentials credentials) {
		return SimpleStorage.load(address, web3j, credentials, GAS_PRICE, GAS_LIMIT);
	}
	public InsuranceContract loadInsuranceContract(String address, Web3j web3j, Credentials credentials) {
		return InsuranceContract.load(address, web3j, credentials, GAS_PRICE, GAS_LIMIT);
	}
	
	//顯示數值
	public String showValue() throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		Credentials credentials = getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);		
		SimpleStorage simpleStorage = loadSimpleStorageContract
				(SIMPLESTORAGE_CONTRACT_ADDRESS, web3j, credentials);
		InsuranceContract insuranceContract = loadInsuranceContract
				(INSURANCE_CONTRACT_ADDRESS, web3j, credentials);
		BigInteger currentValue;
		currentValue = simpleStorage.get().send();
		return currentValue.toString();
	}
	
	//輸入數值
	public void InsertValue(BigInteger count) throws Exception {
		Web3j web3j = Web3j.build(new HttpService(ganacheNode));
		Credentials credentials = getCredentialsFromPrivateKey(INSURANCECORP_PRIVATE_KEY);		
		SimpleStorage simpleStorage = loadSimpleStorageContract
				(SIMPLESTORAGE_CONTRACT_ADDRESS, web3j, credentials);
//		BigInteger currentValue;
//		simpleStorage.set(new BigInteger("1")).send();
		simpleStorage.set(count).send();
		
	}
	//交易
	public void transferETH(Web3j web3j, Credentials credentials, String toEOA, String eth) {
		try {
			String fromEOA = credentials.getAddress();
			
			// 設定ETH數量
			BigInteger ethValue = Convert.toWei(eth, Convert.Unit.ETHER).toBigInteger();

			// 設定nonce亂數
			EthGetTransactionCount ethGetTransactionCount = web3j
					.ethGetTransactionCount(fromEOA, DefaultBlockParameterName.LATEST).sendAsync().get();
			BigInteger nonce = ethGetTransactionCount.getTransactionCount();

			// 設定Gas
			BigInteger gasPrice = new BigInteger("" + 1);
			BigInteger gasLimit = new BigInteger("" + 30000);

			// 建立RawTransaction物件
			RawTransaction rawTransaction = RawTransaction.createEtherTransaction(nonce, gasPrice, gasLimit, toEOA,
					ethValue);

			// 對交易進行加簽與加密
			byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
			String hexValue = Numeric.toHexString(signedMessage);

			// 提出交易
			EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).sendAsync().get();

			String txnHash = ethSendTransaction.getTransactionHash();
			System.out.println("傳送ETH交易序號:" + txnHash);

		} catch (Exception e) {
			System.out.println("transferETH,錯誤:" + e);
		}
		
	}
	//投保
	public void Insured(Web3j web3j, Credentials credentials, String PATIENT_EOA, String name, String address) throws Exception {
		InsuranceContract insuranceContract = loadInsuranceContract
				(INSURANCE_CONTRACT_ADDRESS, web3j, credentials);	
		insuranceContract.insPatient(PATIENT_EOA, name, address).send();
	}
	//查詢保單是否成立
	public boolean checkInsuranceContract(Web3j web3j, Credentials credentials, String PATIENT_EOA) throws Exception {
		InsuranceContract insuranceContract = loadInsuranceContract
				(INSURANCE_CONTRACT_ADDRESS, web3j, credentials);	
		return insuranceContract.isPatientExist(PATIENT_EOA).send();
	}
	//啟動Oracle服務
	public void startOracle(Web3j web3j, Credentials credentials, String contractAddr) throws Exception{
		// 設定過濾條件
		EthFilter filter = new EthFilter(DefaultBlockParameterName.LATEST, DefaultBlockParameterName.LATEST,
				contractAddr);
		// 取得事件topic的hash code
		String eventTopicHash = Hash.sha3String("insRecord");
		
		// 交易事件的Log
		Function transLog = new Function("", Collections.<Type>emptyList(),
				Arrays.asList(new TypeReference<Uint>() {
				}, new TypeReference<Uint>() {
				}, new TypeReference<Uint>() {
				}, new TypeReference<Uint>() {
				}));
		System.out.println("Oracle service start...");
		
		// 持續偵測事件
		Subscription subscription = web3j.ethLogObservable(filter).subscribe(new Action1<Log>() {
			public void call(Log log){
				List<String> list = log.getTopics();
				// 輪詢事件中的Topic
				for (String topic : list) {
					if (topic.equals(eventTopicHash)) {
						System.out.println("處理交易事件");
//						handleTransEvent(log, transLog);
						handleTransEvent(web3j, credentials, log, transLog);
					}
				}
			}
		});
		
	}
	//新增病歷
	public void insRecord(Web3j web3j, Credentials credentials, String PATIENT_EOA, String symptom, String cause,
			int day, int money) throws Exception {
		InsuranceContract insuranceContract = loadInsuranceContract
				(INSURANCE_CONTRACT_ADDRESS, web3j, credentials);
		// 新增病歷
		insuranceContract.insRecord(PATIENT_EOA, symptom, cause, new BigInteger("" + day), new BigInteger("" + money)).send();
		System.out.println("新增病歷，病患情況："+ symptom +"事由："+ cause +"住院天數：" + day);
		
	}
	//設定醫院EOA
	public void setHospitalEOA(Web3j web3j, Credentials credentials, String HOSPITAL_EOA) throws Exception {
		InsuranceContract insuranceContract = loadInsuranceContract
				(INSURANCE_CONTRACT_ADDRESS, web3j, credentials);
		insuranceContract.setHospital(HOSPITAL_EOA).send();		
	}
	//查詢醫院EOA
	public String getHospitalEOA(Web3j web3j, Credentials credentials) throws Exception {
		InsuranceContract insuranceContract = loadInsuranceContract
				(INSURANCE_CONTRACT_ADDRESS, web3j, credentials);
		return insuranceContract.getHospital().send();
	}
	// 處理區塊鏈事件
	public void handleTransEvent(Web3j web3j, Credentials credentials, Log log, Function function){
		List<Type> nonIndexedValues = FunctionReturnDecoder.decode(log.getData(), function.getOutputParameters());
		int inx = 0;
		String PATIENT_EOA = ""; // 病患EOA
		BigInteger recordInx = BigInteger.ZERO; // 病歷序號
		BigInteger days = BigInteger.ZERO; // 住院天數
		BigInteger money = BigInteger.ZERO; // 住院金額	
		for (Type type : nonIndexedValues) {
			if (inx == 0) PATIENT_EOA = Numeric.toHexStringWithPrefix((BigInteger) type.getValue());//病患EOA		
			if (inx == 1) recordInx = (BigInteger) type.getValue();//病歷序號		
			if (inx == 2) days = (BigInteger) type.getValue();//住院天數
			if (inx == 3) money = (BigInteger) type.getValue();//理賠金額
			inx++;
		}	
		System.out.println("保險受益人:" + PATIENT_EOA);
		System.out.println("病歷序號:" + recordInx.longValueExact());
		System.out.println("住院天數:" + days.longValueExact());
		System.out.println("住院金額:" + money.longValueExact());
		
		// 撥款理賠金(住院天數*住院金額)
		transferETH(web3j, credentials, PATIENT_EOA, "" +days.multiply(money).longValueExact());//ETHER
		
	}






  
}
