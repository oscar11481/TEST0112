package efia.test0112.service;

import java.math.BigInteger;

import org.web3j.abi.datatypes.Function;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Log;

import efia.test0112.entity.Student;
import nccu.blockchain.Contract.InsuranceContract;
import nccu.blockchain.Contract.SimpleStorage;

public interface NccuWeb3jService {
	//顯示版本
	String printWeb3Version(Web3j web3j);
	//從private key對應出帳戶
	Credentials getCredentialsFromPrivateKey(String private_key);
	//部署測試合約
	String deploySimpleStorageContract(Web3j web3j, Credentials credentials) throws Exception;
	//部署醫療保險合約
	String deployInsuranceContract(Web3j web3j, Credentials credentials) throws Exception;
	//載入測試合約
	SimpleStorage loadSimpleStorageContract(String address, Web3j web3j, Credentials credentials);
	//載入醫療保險合約
	InsuranceContract loadInsuranceContract(String address, Web3j web3j, Credentials credentials);
	//顯示數值
	String showValue() throws Exception;
	//輸入數值
	void InsertValue(BigInteger count) throws Exception;
	//交易
	void transferETH(Web3j web3j, Credentials credentials, String toEOA, String eth);
	//投保
	void Insured(Web3j web3j, Credentials credentials, String PATIENT_EOA, String name, String address) throws Exception;
	//查詢保單是否成立
	boolean checkInsuranceContract(Web3j web3j, Credentials credentials, String PATIENT_EOA) throws Exception;
	//啟動Oracle服務
	void startOracle(Web3j web3j, Credentials credentials, String contractAddr) throws Exception;	
	//新增病歷
	void insRecord(Web3j web3j, Credentials credentials, String PATIENT_EOA,  String symptom, String cause, int day, int money) throws Exception;
	//設定醫院EOA
	void setHospitalEOA(Web3j web3j, Credentials credentials, String HOSPITAL_EOA) throws Exception;
	//查詢醫院EOA
	String getHospitalEOA(Web3j web3j, Credentials credentials) throws Exception;
	// 處理區塊鏈事件
	void handleTransEvent(Web3j web3j, Credentials credentials, Log log, Function function);
}
