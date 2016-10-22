import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;  


class node{
    int x=0,y=0;
    int xx,yy;
    int t;
}
class edg{
	
    int x,y;
}
public class demo {

	/**
	 * @param args
	 */
static int max=99999;
static int m;
static int n;
static int Map[][]=new int [8][8];
static boolean vis[][][]=new boolean [8][8][4],us[][]=new boolean[8][8];//标记箱子推过的方向  人走过的点
static int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
static node st=new node();
static node []arr1=new node[max];
static edg []arr2=new edg[max];
static edg a=new edg();
static Queue<node> q=new LinkedList<node>();
static Queue<edg> qq = new LinkedList<edg>();
static int numb=0;
static int num=0;
public static void Bfs(){
	

	boolean us[][]=new boolean[8][8];
	for(int i=0;i<8;i++)
		for(int j=0;j<8;j++){
			us[i][j]=false;
		}
	qq.offer(arr2[num++]);
	int index=0;
	while((a=qq.poll())!=null){
			index+=1;
			

	        for(int i=0;i<4;i++){
	            int xx,yy;
	            xx=a.x+dir[i][0];
	            yy=a.y+dir[i][1];

	            if(xx>=0&&xx<n&&yy>=0&&yy<m)
	            {
	            	
	                if(xx==st.x&&yy==st.y)
	                {
	                    int x=st.x+dir[i][0];
	                    int y=st.y+dir[i][1];
	                    if(x>=0&&x<n&&y>=0&&y<m)
	                    {
	                        if(!vis[x][y][i]&&Map[x][y]!=1)  //能推且到达的点不是墙
	                        {
	                        
	                            arr1[numb].x=x;
	                            arr1[numb].y=y;
	                            arr1[numb].xx=xx;
	                            arr1[numb].yy=yy;
	                            arr1[numb].t=st.t+1;
	                            q.offer(arr1[numb++]);
	                            vis[x][y][i]=true ;
	                        }
	                    }
	                }
	                else if(!us[xx][yy]&&Map[xx][yy]!=1)
	                {
	                    us[xx][yy]=true ;
	                    arr2[num].x=xx;
	                    arr2[num].y=yy;
	                    qq.offer(arr2[num++]);

	                }
	            }
	        }
	    }
	

	
}
public static void bfs(){
	while(!q.isEmpty()){
		q.poll();
		}
	arr1[numb]=st;
	q.offer(arr1[numb++]);
	 while(!q.isEmpty())
	    {
	        st=q.poll();
	       
	        if(Map[st.x][st.y]==3)
	        {
	            System.out.println(st.t);
	            return;
	        }
	        arr2[num].x=st.xx;
	        arr2[num].y=st.yy;
	        Bfs();
	    }
	
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t;
		Scanner in=new Scanner(System.in);
		t=in.nextInt();
		while(t--!=0){
			m=in.nextInt();
			n=in.nextInt();
			for(int i=0;i<n;i++)
	        {
	            for(int j=0;j<m;j++)
	            {
	            	
	            	Map[i][j]=in.nextInt();
	                if(Map[i][j]==2){
	                	st.x=i;
	                	st.y=j;

	                 }
	                if(Map[i][j]==4){
	                	st.xx=i;
	                    st.yy=j;
	                 }
	            }
	        }
			st.t=0;
	        for(int i=0;i<8;i++)
	        	for(int j=0;j<8;j++)
	        		for(int p=0;p<4;p++)
	        			vis[i][j][p]=false;
	        for(int i=0;i<max;i++){
	        	arr1[i]=new node();
	    		arr2[i]=new edg();
	    		
	    	}
	        bfs();
		}
	}

}
