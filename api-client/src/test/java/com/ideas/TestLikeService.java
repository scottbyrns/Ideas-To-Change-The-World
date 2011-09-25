package com.ideas;

import com.ideas.api.client.services.ideas.LikeService;
import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Like;
import com.ideas.entities.ideas.LikeCount;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the like service.
 */
public class TestLikeService
{

    /**
     * Test creating a new like.
     */
    @Test
    public void testCreateLike()
    {
        Like like = new Like();
        like.setIdeaId(2);
        like.setUserId(2);

        LikeService likeService = new LikeService();
        likeService.createLike(like);
    }

    @Test
    public void testGetLikeCountForIdea()
    {
        Idea idea = new Idea();
        idea.setId(1);

        LikeService likeService = new LikeService();
        LikeCount likeCount = likeService.getLikeCountForIdea(idea);

        assertEquals(
                "",
                1L,
                likeCount.getCount()
        );
    }
}
