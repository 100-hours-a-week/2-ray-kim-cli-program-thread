import java.util.Scanner;
import constants.Constants;
import store.AppleStore;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppleStore store = new AppleStore();

        while (true) {
            System.out.println("\n=== 애플 스토어에 오신 걸 환영합니다! ===");
            System.out.println("1. 컴퓨터");
            System.out.println("2. 모바일");
            System.out.println("3. 프로그램 종료");
            System.out.print("원하시는 카테고리를 선택하세요: ");

            int category = scanner.nextInt();

            if (category == Constants.CATEGORY_EXIT) {
                System.out.println("프로그램을 종료합니다. 감사합니다!");
                scanner.close();
                return;
            }

            if (category == Constants.CATEGORY_COMPUTER) {
                System.out.println("\n=== 컴퓨터 카테고리 ===");
                System.out.println("1. iMac");
                System.out.println("2. model.product.computer.MacBook");
                System.out.println("3. 이전 메뉴로");
                System.out.print("원하시는 제품군을 선택하세요: ");

                int computerType = scanner.nextInt();
                if (computerType == Constants.COMPUTER_BACK) continue;

                if (computerType == Constants.COMPUTER_IMAC) {
                    store.displayIMacs();
                    System.out.print("\n구매하실 제품의 번호를 입력하세요: ");
                    int productIndex = scanner.nextInt();
                    store.purchaseProduct(store.getIMacByIndex(productIndex));
                } else if (computerType == Constants.COMPUTER_MACBOOK) {
                    store.displayMacBooks();
                    System.out.print("\n구매하실 제품의 번호를 입력하세요: ");
                    int productIndex = scanner.nextInt();
                    store.purchaseProduct(store.getMacBookByIndex(productIndex));
                }

            } else if (category == Constants.CATEGORY_MOBILE) {
                System.out.println("\n=== 모바일 카테고리 ===");
                System.out.println("1. iPhone");
                System.out.println("2. iPad");
                System.out.println("3. 이전 메뉴로");
                System.out.print("원하시는 제품군을 선택하세요: ");

                int mobileType = scanner.nextInt();
                if (mobileType == Constants.MOBILE_BACK) continue;

                if (mobileType == Constants.MOBILE_IPHONE) {
                    store.displayIPhones();
                    System.out.print("\n구매하실 제품의 번호를 입력하세요: ");
                    int productIndex = scanner.nextInt();
                    store.purchaseProduct(store.getIPhoneByIndex(productIndex));
                } else if (mobileType == Constants.MOBILE_IPAD) {
                    store.displayIPads();
                    System.out.print("\n구매하실 제품의 번호를 입력하세요: ");
                    int productIndex = scanner.nextInt();
                    store.purchaseProduct(store.getIPadByIndex(productIndex));
                }
            }
        }
    }
}