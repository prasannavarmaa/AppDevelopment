package com.fundplus.Microservices.Serviceimpl;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fundplus.Microservices.Model.Admincreatecampaign;

@Service
public class Admincreatecampaignserviceimpl {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  // public ResponseEntity<?> saveAdmincampaigns(Admincreatecampaign campaign) {

  // ResponseEntity<Admincreatecampaign> responseEntity =
  // restTemplate().postForEntity(
  // "http://localhost:8081/adminsavecampaigns",
  // campaign,
  // Admincreatecampaign.class);

  // return new ResponseEntity<>("user campaign added successfully",
  // HttpStatus.OK);
  // }

  public ResponseEntity<Admincreatecampaign> saveAdmincampaigns(Admincreatecampaign campaign) {

    ResponseEntity<Admincreatecampaign> responseEntity = restTemplate().postForEntity(
        "http://localhost:8081/api/fundplus/adminaddcampaigns",
        campaign,
        Admincreatecampaign.class);

    return responseEntity;
  }
public List<Admincreatecampaign> getAllCampaignsList() {
    ResponseEntity<List<Admincreatecampaign>> responseEntity = restTemplate().exchange(
            "http://localhost:8081/getalladmincampaigns",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Admincreatecampaign>>() {});

    return responseEntity.getBody();
}

}
