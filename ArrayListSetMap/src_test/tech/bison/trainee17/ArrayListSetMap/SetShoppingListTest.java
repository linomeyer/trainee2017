package tech.bison.trainee17.ArrayListSetMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;

import org.junit.Test;

public class SetShoppingListTest {
  @Test
  public void shoppingList_addValues_noDuplicatedValues() throws Exception {

    HashSet<String> shoppingList = new HashSet<String>();

    shoppingList.add("lemon");
    shoppingList.add("apple");
    shoppingList.add("banana");
    shoppingList.add("apple");
    shoppingList.add("strawberry");

    assertThat(shoppingList.size(), is(4));
    assertThat(shoppingList.contains("lemon"), is(true));
  }
}
