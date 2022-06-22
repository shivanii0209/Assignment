package com.zensar.endpoints;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "myEndPoint")
public class MyEndPoint {
	Map<String, List<String>> releaseNoteMap =new LinkedHashMap<>();
	@PostConstruct
	public void initEndPoint() {
		releaseNoteMap.put("Shivani",Arrays.asList("End Point Created","Added new End point"));
		releaseNoteMap.put("Shivani Mane",Arrays.asList("Done","Dusted"));
	}
	@ReadOperation
	public Map<String, List<String>> getMyEndPoint(){
		return releaseNoteMap;
	}
	@ReadOperation
	public List<String> getByName(@Selector String Name){
		return releaseNoteMap.get(Name);
		
	}
	@WriteOperation
	public void addData(@Selector   String Name, String Description) {
		releaseNoteMap.put(Name,Arrays.stream(Description.split(",")).collect(Collectors.toList()) );
		
	}
	@DeleteOperation
	public void deleteEndPoint(@Selector String Name) {
		releaseNoteMap.remove(Name);
	}
}
