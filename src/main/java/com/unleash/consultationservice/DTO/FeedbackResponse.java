package com.unleash.consultationservice.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedbackResponse {
    private String patient;
    private String counselor;
    private String patientpic;
    private String feedback;
    private String timestamp;
    private int rating;
}
