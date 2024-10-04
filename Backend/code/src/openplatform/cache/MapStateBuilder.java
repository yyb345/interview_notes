package openplatform.cache;

/**
 * Created by yangyibo
 * Date: 2019/9/18
 * Time: 上午11:33
 */
public class MapStateBuilder<K,V> {
	@Override
	public String toString() {
		return super.toString();
	}



	//	public long expireAfterWriteMillons = -1L;
//
//
//	YidianMapState<K,V> build(){
//		return new YidianMapState(this);
//	}
//
//
//
//	public MapStateBuilder<K,V> expireAfterWrite(Long duration, TimeUnit timeUnit){
//
//		Preconditions.checkState(this.expireAfterWriteMillons == -1L, "expireAfterWrite was already set to %s ns", new Object[]{this.expireAfterWriteMillons});
//		Preconditions.checkArgument(duration >= 0L, "duration cannot be negative: %s %s", new Object[]{duration, timeUnit});
//		this.expireAfterWriteMillons = timeUnit.toMillis(duration);
//		return this;
//	}


}
