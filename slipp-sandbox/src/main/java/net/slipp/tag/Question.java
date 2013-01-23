package net.slipp.tag;

import java.util.HashSet;
import java.util.Set;

public class Question {
    private Set<Tag> originalTags = new HashSet<Tag>();
    
    public Question(Set<Tag> tags) {
        this.originalTags = tags;
    }
    
    public void update(Set<Tag> tags) {
        // TODO 
    }
    
    public Set<Tag> getOriginalTags() {
        return originalTags;
    }
}
