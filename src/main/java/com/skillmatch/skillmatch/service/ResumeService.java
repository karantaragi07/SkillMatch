package com.skillmatch.skillmatch.service;

import com.skillmatch.skillmatch.util.PdfParseUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

import java.io.IOException;

@Service
public class ResumeService {

    private final SkillExtractionService skillExtractionService;

    public ResumeService() {
        this.skillExtractionService = new SkillExtractionService();
    }

    public String extractTextFromPdf(MultipartFile file) throws IOException {
        return PdfParseUtil.extractTextFromPdf(file);
    }

    public Set<String> extractSkillsFromText(String text) {
        return skillExtractionService.extractSkills(text);
    }

    public Set<String> extractSkillsFromResume(MultipartFile file) throws IOException {
        String text = extractTextFromPdf(file);
        return extractSkillsFromText(text);
    }
}