package net.slipp.tag;

import java.util.Set;

public class QuestionController {
    private TagProcessor tagProcessor;
    private QuestionService questionService;
    
    public void setTagProcessor(TagProcessor tagProcessor) {
        this.tagProcessor = tagProcessor;
    }
    
    public void create(String title, String contents, String plainTags) {
        Set<Tag> tags = tagProcessor.processTags(plainTags);
        questionService.create(title, contents, tags);
    }
    
    public void update(Long id, String title, String contents, String plainTags) {
        Set<Tag> tags = tagProcessor.processTags(plainTags);
        questionService.update(id, title, contents, tags);
    }
}
