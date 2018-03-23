package tech.bison.trainee17.collections;

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
    assertThat(shoppingList.contains("apple"), is(true));
    assertThat(shoppingList.contains("banana"), is(true));
    assertThat(shoppingList.contains("strawberry"), is(true));
  }

  @Test
  public void createShoppingList_addValues_removeValues() throws Exception {
    HashSet<String> shoppingList = new HashSet<String>();

    shoppingList.add("lemon");
    shoppingList.add("apple");
    shoppingList.add("banana");
    shoppingList.add("strawberry");

    shoppingList.remove("apple");

    assertThat(shoppingList.contains("apple"), is(false));
  }
}
