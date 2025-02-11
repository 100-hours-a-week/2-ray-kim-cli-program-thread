import java.util.Scanner;
import constants.Category;
import constants.ProductType;
import store.AppleStore;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppleStore store = new AppleStore();

        while (true) {
            System.out.println("\n=== 애플 스토어에 오신 걸 환영합니다! ===");
            System.out.println("1. " + Category.COMPUTER.getDisplayName());
            System.out.println("2. " + Category.MOBILE.getDisplayName());
            System.out.println("3. 프로그램 종료");
            System.out.print("원하시는 카테고리를 선택하세요: ");

            int categoryChoice = scanner.nextInt();

            if (categoryChoice == 3) {
                store.shutdown();  // 스레드 종료 처리
                System.out.println("프로그램을 종료합니다. 감사합니다!");
                scanner.close();
                return;
            }

            Category selectedCategory = categoryChoice == 1 ? Category.COMPUTER : Category.MOBILE;
            ProductType[] availableProducts = selectedCategory.getProductTypes();

            System.out.println("\n=== " + selectedCategory.getDisplayName() + " 카테고리 ===");
            for (int i = 0; i < availableProducts.length; i++) {
                System.out.println((i + 1) + ". " + availableProducts[i].getDisplayName());
            }
            System.out.println((availableProducts.length + 1) + ". 이전 메뉴로");
            System.out.print("원하시는 제품군을 선택하세요: ");

            int productChoice = scanner.nextInt();
            if (productChoice == availableProducts.length + 1) continue;

            if (productChoice > 0 && productChoice <= availableProducts.length) {
                ProductType selectedType = availableProducts[productChoice - 1];
                store.displayProductsByType(selectedType);
                System.out.print("\n구매하실 제품의 번호를 입력하세요: ");
                int productIndex = scanner.nextInt();
                store.purchaseProduct(store.getProductByTypeAndIndex(selectedType, productIndex));
            }
        }
    }
}