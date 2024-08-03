package hello.upload.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ItemRepository {

    private final HashMap<Long, Item> store = new HashMap<>();
    private long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }
}
