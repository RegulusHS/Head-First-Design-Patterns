package chapter9;

import java.util.ArrayList;

@Deprecated
public class PancakeHouseIterator implements Iterator{
    ArrayList<MenuItem> menuItems;
    int position = 0;

    public PancakeHouseIterator(ArrayList menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.size() || menuItems.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems.get(position);
        position = position + 1;
        return menuItem;
    }
}
