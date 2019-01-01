package com.sabre.courseapi.topics;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework","Spring framework Description"),
			new Topic("Java", "Core Java","Core java description")
			));
	
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).get(); 
		// @formatter:on

		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		topicRepository.deleteById(id);
		topicRepository.save(topic);
		/*
		 * for(int i=0; i<topics.size(); i++) { Topic eachTopic = topics.get(i);
		 * if(eachTopic.getId().equals(id)) { topics.set(i, topic); } }
		 */
	}

	public void delteTopic(String id) {
		topicRepository.deleteById(id);
		
	}

}
