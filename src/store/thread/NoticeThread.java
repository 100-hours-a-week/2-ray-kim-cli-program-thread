// store/thread/NoticeThread.java
package store.thread;

public class NoticeThread extends Thread {
    private volatile boolean isRunning = true;
    private int currentIndex = 0;
    private final String[] notices = {
            "🎉 iPhone 16, Pro, Pro Max 출시!",
            "🔧 AS 센터: 평일 09:00-18:00 운영",
            "💝 애플케어 + 가입시 첫 달 무료!",
            "🌟 아이폰 SE4 곧 출시 예정",
            "⚡ 교육 할인 최대 20% 진행중",
            "🎨 최강의 성능을 뽐내는, M4 칩셋",
            "📱 iPhone 보상 판매 최대 50만원",
            "💻 신학기 프로모션 진행중: 맥북 구매 시 에어팟 무료",
            "🎮 Apple Arcade & Apple TV 3개월 무료"
    };

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(5000);
                currentIndex = (currentIndex+1) % notices.length;
                String notice = notices[currentIndex];
                if(currentIndex==1){
                    System.out.println("\n[공지] " + notice);
                }else{
                    System.out.println("[공지] " + notice);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stopNotice() {
        isRunning = false;
    }
}