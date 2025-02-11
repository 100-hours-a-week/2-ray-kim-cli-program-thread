package store;

import constants.ProductType;
import model.product.*;
import model.product.computer.*;
import model.product.mobile.*;
import store.thread.NoticeThread;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppleStore {
    private List<Product> inventory;
    private NoticeThread noticeThread;

    public AppleStore() {
        inventory = new ArrayList<>();
        initializeInventory();
        startNoticeThread();
    }

    private void startNoticeThread() {
        noticeThread = new NoticeThread();
        noticeThread.start();
    }

    private void initializeInventory() {
        // iMac
        inventory.add(new IMac("iMac 24", 1890000, "블루", 256,
                "M1", 8, 24.0, "기가비트 이더넷"));
        inventory.add(new IMac("iMac 24", 2290000, "실버", 512,
                "M1", 16, 24.0, "없음"));

        // MacBook
        inventory.add(new MacBook("MacBook Pro 14", 2890000, "스페이스 그레이", 512,
                "M4 Pro", 16, "Pro", 1.6, "나노텍스처 글래스"));
        inventory.add(new MacBook("MacBook Air", 1890000, "미드나이트", 256,
                "M4", 8, "Air", 1.24, "일반"));

        // iPad
        inventory.add(new IPad("iPad Pro 12.9\"", 1729000, "실버", 256,
                "WiFi+5G", 12.9, "4세대", "Magic Keyboard"));
        inventory.add(new IPad("iPad Air", 929000, "스페이스 그레이", 64,
                "WiFi", 10.9, "4세대", "Magic Keyboard"));

        // iPhone
        inventory.add(new IPhone("iPhone 16 Pro", 1550000, "네추럴 티타늄", 256,
                "5G", 6.1, "A18 Pro", "16 Pro"));
        inventory.add(new IPhone("iPhone 16", 1250000, "화이트", 128,
                "5G", 6.1, "A18", "16"));
    }

    public void displayProductsByType(ProductType type) {
        System.out.println("\n=== " + type.getDisplayName() + " 제품 목록 ===");
        List<Product> products = getProductsByType(type);
        for (int i = 0; i < products.size(); i++) {
            System.out.println("\n" + (i + 1) + "번 제품:");
            products.get(i).displayInfo();
            System.out.println("---------------");
        }
    }

    public List<Product> getProductsByType(ProductType type) {
        return inventory.stream()
                .filter(product -> product.getType() == type)
                .collect(Collectors.toList());
    }

    public Product getProductByTypeAndIndex(ProductType type, int index) {
        List<Product> products = getProductsByType(type);
        if (index > 0 && index <= products.size()) {
            return products.get(index - 1);
        }
        return null;
    }

    public void purchaseProduct(Product product) {
        if (product != null) {
            System.out.println("\n=== 구매가 완료되었습니다 ===");
            System.out.println("구매하신 제품 정보:");
            product.displayInfo();
        } else {
            System.out.println("잘못된 제품 번호입니다.");
        }
    }

    public void shutdown() {
        if (noticeThread != null) {
            noticeThread.stopNotice();
        }
    }
}