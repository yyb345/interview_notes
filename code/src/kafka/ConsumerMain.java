package kafka;

/**
 * Created by yangyibo
 * Date: 2019/4/13
 * Time: 上午9:29
 */
public class ConsumerMain {

	public static void main(String[] args) {
		String brokerList = "10.120.14.1:9092";
		String groupId = "testGroup2222";
		String topic = "push_light_cjv";
		int consumerNum = 10;

		ConsumerGroup consumerGroup = new ConsumerGroup(consumerNum, groupId, topic, brokerList);
		consumerGroup.execute();
	}
}
