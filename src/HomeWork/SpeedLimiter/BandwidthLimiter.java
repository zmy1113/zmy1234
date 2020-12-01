package HomeWork.SpeedLimiter;

public class BandwidthLimiter {
    /*  KB，单位  */
    private static Long KB = 1024l;

    /* 最小的文件大小单位  */
    private static Long Length = 1024l;

    /*  将上传或下载的字节数  */
    private int bytesWillBeSentOrReceive = 0;

    /*  当最后一字节被上传或下载时  */
    private long lastPieceSentOrReceiveTick = System.nanoTime();

    /*  最大速度为1024kb/s  */
    private int maxRate = 1024;

    /**
     * 以微秒为单位，传输某文件所花费的理论时间
     */
    private long timeCostFile = (1000000000l * Length) / (this.maxRate * KB);

    /**
     * 初始化badnwidthlimiter对象的速率
     */
    public BandwidthLimiter(int maxRate) {
        this.setMaxRate(maxRate);
    }

    /**
     * 设置最大上载或下载速率（KB/s）。maxRate必须大于0。
     */
    public synchronized void setMaxRate(int maxRate) throws IllegalArgumentException {
        if (maxRate < 0) {
            throw new IllegalArgumentException(" maxRate can not less than 0 ");
        }
        this.maxRate = maxRate < 0 ? 0 : maxRate;
        if (maxRate == 0)
            this.timeCostFile = 0;
        else
            this.timeCostFile = (1000000000L * Length) / (this.maxRate * KB);
    }

    public synchronized void limitNextBytes() {
        this.limitNextBytes(1);
    }

    public synchronized void limitNextBytes(int len) {
        this.bytesWillBeSentOrReceive += len;

        /*已发送文件大小与理论对比*/
        while (this.bytesWillBeSentOrReceive > Length) {
            long nanoTime = System.nanoTime();
            long missedTime = this.timeCostFile - (nanoTime - this.lastPieceSentOrReceiveTick);
            if (missedTime > 0) {
                try {
                    Thread.sleep(missedTime / 1000000, (int) (missedTime % 1000000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.bytesWillBeSentOrReceive -= Length;
            this.lastPieceSentOrReceiveTick = nanoTime + (missedTime > 0 ? missedTime : 0);
        }
    }
}
