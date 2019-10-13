package com.kayleoi.springbootcommunity.cache;

import com.kayleoi.springbootcommunity.dto.HotTagDTO;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author kay三石
 * @date:2019/10/8
 */
@Component
public class HotTagCache {
    private List<String> hots = new ArrayList<>();

    public List <String> getHots() {
        return hots;
    }

    public void setHots(List <String> hots) {
        this.hots = hots;
    }

    public void updateTags(Map<String, Integer> tags) {
        int max = 10;
        PriorityQueue<HotTagDTO> priorityQueue = new PriorityQueue<>(max);

        tags.forEach((name, priority) -> {
            HotTagDTO hotTagDTO = new HotTagDTO();
            hotTagDTO.setName(name);
            hotTagDTO.setPriority(priority);
            if (priorityQueue.size() < max) {
                priorityQueue.add(hotTagDTO);
            } else {
                HotTagDTO minHot = priorityQueue.peek();
                if (hotTagDTO.compareTo(minHot) > 0) {
                    priorityQueue.poll();
                    priorityQueue.add(hotTagDTO);
                }
            }
        });


        List<String> sortedTags = new ArrayList<>();

        HotTagDTO poll = priorityQueue.poll();
        while (poll != null) {
            sortedTags.add(0, poll.getName());
            poll = priorityQueue.poll();
        }
        hots = sortedTags;
    }


}
