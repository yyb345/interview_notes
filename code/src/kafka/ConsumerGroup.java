package kafka;

/**
 * Created by yangyibo
 * Date: 2019/4/13
 * Time: 上午9:28
 */


import java.util.ArrayList;
import java.util.List;

public class ConsumerGroup {

	private List<ConsumerRunnable> consumers;

	public ConsumerGroup(int consumerNum, String groupId, String topic, String brokerList) {
		consumers = new ArrayList<>(consumerNum);
		for (int i = 0; i < consumerNum; i++) {
			ConsumerRunnable consumerThread = new ConsumerRunnable(i,brokerList, groupId, topic);
			consumers.add(consumerThread);
		}
	}

	public void execute() {
		for (ConsumerRunnable task : consumers) {
			new Thread(task).start();
		}
	}
}
