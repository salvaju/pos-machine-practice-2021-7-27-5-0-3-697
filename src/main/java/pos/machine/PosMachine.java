package pos.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PosMachine {
    public String generateReceipt(List<String> barcodes) {

        List<Item> itemList;
        int totalAmount;

        itemList = convertBarcodeToItems(barcodes);
        totalAmount = evaluateTotalPrice(itemList);

        return createReceipt(itemList, totalAmount);
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
                    System.out.println("Invalid Item");
            }
        }

        List<Item> itemList = new ArrayList<>();
        itemList.add(coke);
        itemList.add(sprite);
        itemList.add(battery);

        return itemList;

    }

    public int evaluateTotalPrice(List<Item> itemList) {

        return itemList.stream()
                .collect(Collectors.summingInt(i -> i.subTotal));
    }

    public String createReceipt(List<Item> itemList, int total) {

        String receipt = "";

        for (Item item: itemList) {
            String joinedItemInfo = joinItemInfo(item);
            receipt = joinReceipt(joinedItemInfo, receipt);
        }

        return "***<store earning no money>Receipt***\n" +
                receipt +
                "----------------------\n" +
                "Total: "+  total  + " (yuan)\n" +
                "**********************";

    }

    public String joinItemInfo(Item item) {
        return  "Name: " + item.getName() +", Quantity: " + item.getQuantity() + ", Unit price: "+ item.getPrice() +" (yuan), Subtotal: " + item.getSubTotal() + " (yuan)\n";
    }

    public String joinReceipt(String Iteminfo, String receipt) {
        return receipt + Iteminfo;
    }


}