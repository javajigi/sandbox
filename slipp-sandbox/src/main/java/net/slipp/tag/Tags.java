package net.slipp.tag;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class Tags {
    private void processRemoveTags() {
        SetView<Tag> removedTags = Sets.difference(originalTags, pooledTags);
        for (Tag tag : removedTags) {
            tag.deTagged();
        }        
    }

    private void processAddTags() {
        SetView<Tag> addedTags = Sets.difference(pooledTags, originalTags);
        for (Tag tag : addedTags) {
            tag.tagged();
        }
    }
}
