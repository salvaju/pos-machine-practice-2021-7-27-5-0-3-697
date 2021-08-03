package pos.machine;

import java.util.ArrayList;
import java.util.List;

import static pos.machine.ItemDataLoader.loadAllItemInfos;

public class PosMachine {
    public String generateReceipt(List<String> barcodes) {
        convertBarcodeToItems(barcodes);
        return null;
    }

    public List<Item> convertBarcodeToItems(List<String> barcodeList) {
        List<ItemInfo> itemInfos = ItemDataLoader.loadAllItemInfos();

        Item coke = new Item();
        Item sprite = new Item();
        Item battery = new Item();


        for (String barcode: barcodeList) {
            switch (barcode) {
                case "ITEM000000":
                    coke.setName(itemInfos.get(0).getName());
                    coke.addQuantity();
                    coke.setPrice(itemInfos.get(0).getPrice());
                    coke.addSubTotal();
                    break;
                case "ITEM000001":
                    sprite.setName(itemInfos.get(1).getName());
                    sprite.addQuantity();
                    sprite.setPrice(itemInfos.get(1).getPrice());
                    sprite.addSubTotal();
                    break;
                case "ITEM000004":
                    battery.setName(itemInfos.get(2).getName());
                    battery.addQuantity();
                    battery.setPrice(itemInfos.get(2).getPrice());
                    battery.addSubTotal();
                    break;
                default:
                    System.out.println("Cannot Load Data");
            }
        }

        List<Item> itemList = new ArrayList<>();
        itemList.add(coke);
        itemList.add(sprite);
        itemList.add(battery);

        return itemList;

    }
}
