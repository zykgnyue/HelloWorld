package mars.service1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

//��Ҫ�̳�һ��service
public class FirstService extends Service {

 //�󶨵ĺ���һ��service��һ��activity�󶨵�ʱ��ͻ�����������
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("Service onBind");
		Log.i("MyLog", "Service onBind");
		return null;
	}

	//������һ��Servcie����֮�󣬻����ȵ����������
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("Service onCreate");
		Log.i("MyLog", "Service onCreate");
	}
	 
    //������һ��service��ʱ�������������
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("MyLog", "flags------->");
		Log.i("MyLog", "startId------->");
		Log.i("MyLog", "Service onStartCommand");
		System.out.println("flags--->" + flags);
		System.out.println("startId--->" + startId);
		System.out.println("Service onStartCommand");
		return START_NOT_STICKY;
	}

	
	@Override
	public void onDestroy() {
		Log.i("MyLog", "Service onDestory");
		System.out.println("Service onDestory");
		super.onDestroy();
	}
}
