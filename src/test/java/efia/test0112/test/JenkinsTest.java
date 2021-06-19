package efia.test0112.test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import efia.test0112.service.JenkinsService;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.xml.bind.JAXBException;

@RunWith(SpringJUnit4ClassRunner.class)   
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JenkinsTest {
    
    @Autowired
    private JenkinsService jenkinsService;

    @Test
    public void test01isRunning() throws URISyntaxException{
    	jenkinsService.jobBuild("test");
        System.out.println("Server is Running : ");

    }
    
    @Test
    public void test02XMLContentEqual() throws IOException, URISyntaxException{     
        //System.out.println(jenkinsService.XMLContentEqual(jenkinsService.getFileContent
                //(newjobXmlpathname), "EmptyProject"));
    }
    
    @Test
    public void test03createJob() throws IOException, URISyntaxException{     
        //jenkinsService.createJob("Test", jenkinsService.getFileContent(newjobXmlpathname));          
    }    
    
    @Test
    public void test04ScheduleXMLContentEqual() throws IOException, URISyntaxException{     
        //System.out.println(jenkinsService.XMLContentEqual(jenkinsService.getFileContent
                //(TestWebjobXmlpathname), "TestWeb"));
    }
    
    @Test
    public void test05createScheduleJob() throws IOException, URISyntaxException{     
       // jenkinsService.createJob("schedule", jenkinsService.getFileContent(schedulejobXmlpathname));          
    }   
    
    @Test
    public void test06WriteToScheduleXML(){
//        String Expression1 = "/project/triggers/hudson.triggers.TimerTrigger";
//        String name = "spec";
//        String value = "49 14 27 3 *";
//        XMLUtil.WriteToXML(TestWebjobXmlpathname, Expression1, name, value);
    }
    
  
    @Test
    public void test08createJobByOtherJob() throws IOException, URISyntaxException{ 
//        String jobName = "Test";
//        String OtherjobName = "EmptyProject";
//        jenkinsService.createJobByOtherJob(jobName, OtherjobName);
    }
    
    @Test
    public void test09applySchedule() throws URISyntaxException, IOException{
//        String jobName = "TestWeb";
//        jenkinsService.applySchedule(jobName, "");
    }
    
    @Test
    public void test10deployByDate() throws URISyntaxException, IOException, ParseException{     
//        String test="2017/03/28 - 16:55";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd - HH:mm");
//        Date deployDate = sdf.parse(test); 
//        jenkinsService.deployByDate("TestWeb", deployDate, TestWebjobXmlpathname);               
    }
    
    @Test
    public void test11getBuildResult() throws URISyntaxException, IOException{
//        System.out.println(jenkinsService.getBuildResult("DEMOOfficial",19));
    }
    
    @Test
    public void test12getConsoleResult() throws URISyntaxException, IOException{
//        String ConsoleResult = jenkinsService.getConsoleResult("DEMOOfficial", 19);
//        System.out.println(ConsoleResult.contains("but context failed to start"));
//        System.out.println(ConsoleResult);
    }
    
    @Test
    public void test13jobBuild() throws URISyntaxException, IOException{
        //jenkinsService.jobBuild("DEMOTest");
    	//jenkinsService.jobBuild("DEMOOfficial");
        //jenkinsService.jobBuildOfficial("DEMO");
    }
    
    @Test
    public void test14updateProgramInfo() throws ParseException{
//        String SysCd="SPM";
//        String version="0.1.0";
//        String test="2017/03/28 - 16:55";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd - HH:mm");
//        Date deployDate = sdf.parse(test); 
//        ProgramInfo progInfo = new ProgramInfo(SysCd, version, deployDate);
//        programInfoService.updateProgramInfo(progInfo);
    }
    
    @Test
    public void test14getNextBuildNumber() throws URISyntaxException, IOException{

    }
}
