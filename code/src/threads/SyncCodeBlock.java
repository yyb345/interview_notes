package threads;

/**
 * Created by yangyibo
 * Date: 2019/5/5
 * Time: 上午11:00
 */

public class SyncCodeBlock {

	public int i;

	public void syncTask(){
		//同步代码库
		synchronized (this){
			i++;
		}
	}

	public synchronized void syncTask2(){
		i++;
	}


	public static void main(String[] args){

	}
}

