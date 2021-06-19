package efia.test0112.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import efia.test0112.service.JenkinsService;


@Service("jenkinsService")
public class JenkinsServiceImpl implements JenkinsService {

	@Override
	public void jobBuild(String jobName) {
		// TODO Auto-generated method stub
		
	}
    
    
}
