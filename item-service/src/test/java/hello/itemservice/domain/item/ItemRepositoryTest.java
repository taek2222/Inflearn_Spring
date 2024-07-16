package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("ItemA", 10000, 10);

        // when
        Item save = itemRepository.save(item);

        // then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(save);
    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("ItemA", 10000, 10);
        Item item2 = new Item("ItemB", 20000, 30);

        itemRepository.save(item1);
        itemRepository.save(item2);
        // when
        List<Item> items = itemRepository.findAll();

        // then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(item1, item2);
    }

    @Test
    void updateItem() {
        // given
        Item item1 = new Item("ItemA", 10000, 10);

        itemRepository.save(item1);
        Long id = item1.getId();

        // when
        Item item2 = new Item("ItemB", 20000, 30);
        itemRepository.update(id, item2);

        // then
        Item findItem = itemRepository.findById(id);

        assertThat(findItem.getItemName()).isEqualTo(item2.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(item2.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(item2.getQuantity());
    }
}