package efia.test0112.service.impl;
import java.io.IOException;
import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import efia.test0112.service.NccuWeb3jService;
import nccu.blockchain.Contract.InsuranceContract;
import nccu.blockchain.Contract.SimpleStorage;

@Service("nccuWeb3jService")
public class NccuWeb3jServiceImpl implements NccuWeb3jService{
  private final static String ganacheNode = "http://localhost:7545/";
  private final static String INSURANCECORP_PRIVATE_KEY   = 
		  "ef7d86a0ef5b20bf93bd44b209519b4945418710a4e917334fb37fb33b73371c";
  private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
  private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L); // L being long; capital for clarity   
  //測試合約位址
  private final static String SIMPLESTORAGE_CONTRACT_ADDRESS = 
		  "0x4d7E921f70dA4C6b573A11Cd2ECbd0d066988356";
  //醫療保險合約位址
  private final static String INSURANCE_CONTRACT_ADDRESS = 
		  "0x4d7E921f70dA4C6b573A11Cd2ECbd0d066988356";
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
	public void transferETH(Web3j web3j, Credentials credentials, String fromEOA, String toEOA, String eth) {
		try {
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





  
}
