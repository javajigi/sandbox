package net.slipp.tag;

import java.util.HashSet;
import java.util.Set;

public class TagProcessor {
    private TagRepository tagRepository;

    public TagProcessor(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Set<Tag> processTags(String plainTags) {
        Set<String> parsedTags = parseTags(plainTags);

        Set<Tag> tags = new HashSet<Tag>();
        
        for (String name : parsedTags) {
            Tag tag = tagRepository.findByName(name);
            if (tag == null) {
                Tag newTag = Tag.createNewTag(name);
                Tag persisted = tagRepository.save(newTag);
                tags.add(persisted);
            } else {
                tags.add(tag);                
            }
        }
        
        return tags;
    }

    private Set<String> parseTags(String plainTags) {
        // TODO 태그 파싱
        return null;
    }
}