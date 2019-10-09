package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by yangyibo
 * Date: 2019/4/17
 * Time: 下午3:24
 */
public class KafkaProducerDemo {


	private static final String TOPIC = "yali_test";
	private static final String BOOTSTRAP_SERVERS = "10.120.14.1:9092";

	private static KafkaProducer initProducer() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.RETRIES_CONFIG, 1);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 3000);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		return new KafkaProducer(props);
	}

	@SuppressWarnings("unchecked")
	public static Future sendOne(String key, String value) {
		return initProducer().send(new ProducerRecord<>(TOPIC, key, value));
	}



	public static void main(String[] args) throws Exception {

		for(int i=0;i<10000;i++){
			Future aa = KafkaProducerDemo.sendOne("03", "dd");
			System.out.println(">>>>>>>>>>: " + aa.get().toString());
			//	Thread.sleep(3000);

			Future bb = KafkaProducerDemo.sendOne("04", "ee");
			System.out.println(">>>>>>>>>>: " + bb.get().toString());
			//	Thread.sleep(3000);

			Future cc = KafkaProducerDemo.sendOne("03", "ff");
			System.out.println(">>>>>>>>>>: " + cc.get().toString());
			//	Thread.sleep(3000);
		}

	}

//	public static void main(String[] args){
//
//		 Properties properties=new Properties();
//		properties.put("bootstrap.servers", "10.120.14.1:9092");
//		properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
//		properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
//		//properties.put("serializer.class", "kafka.serializer.StringEncoder");
//		//properties.put("request.required.acks", "1");
//
//
//
//		 KafkaProducer kafkaProducer=new KafkaProducer(properties);
//		 ProducerRecord<String,String> message=new ProducerRecord<String, String>("test", 0, System.currentTimeMillis(), "key", "value");
//		 for(int i=0;i<1000;i++) {
//			 Future send = kafkaProducer.send(message);
//			 if(send==null)
//			 	System.out.println("xx");
//		 }
//	}
}
