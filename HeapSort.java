//Sisi Zimmerman, Ivette Chen, Julie Kim
//APCS2 pd8
//HW42
//2014-05-22

/*
SUMMARY:

1. Heapify the data (traverse the array and swap the child with its parent when needed)
2. Remove the max, and put it at the end of the heapified region / beginnning of the sorted region  --> end result is in ascending order
3. Sorted region grows, heapified region shrinks to 0
4. Voila!

*/

  public class HeapSort{
  
  
      public static int[] sort(int[] data){
  
  	//adding as max heap
  	for(int i = 1; i < data.length; i++){
  	    int parentPos;
  	    int addValPos = i;
  	    while(addValPos  > 0){
  		parentPos = (addValPos - 1) / 2;
  		if(data[addValPos] > data[parentPos]){
  		    swap(data, addValPos, parentPos);
  		    addValPos = parentPos;
  		}else{
  		    break;
  		}
  	    }
  	}
  	System.out.println(stringify(data) + "\n");
  		
  	//removing max
  	for (int i = data.length-1 ; i >= 0 ; i--){
  	    int foo = data[i];
  	    swap(data, i, 0);
  	    int pos = 0;
  	    int maxChildPos;
  	    while(pos < i){
  		//System.out.println(stringify(data) + " ?????? foo:" + foo);
  		maxChildPos = maxChildPos(data, pos, i);
  		if ( maxChildPos == -1)
  		    break;
  		else if(foo > data[maxChildPos])
  		    break;
  		else{
  		    swap(data, maxChildPos, pos);
  		    pos = maxChildPos;
  		}
  	    }
  	    //System.out.println(stringify(data) + "   i: " + i);
  
  	}
  	
  	return data;
  
      }
  
      public static int maxChildPos(int[] data,int pos, int length){
  	int retVal;
  	int lc = 2*pos + 1; //index of left child
  	int rc = 2*pos + 2; //index of right child
  
  	//pos is not in the heap or pos is a leaf position
  	if ( pos < 0 || pos >= length || lc >= length )
  	    retVal = -1;
  	//if no right child, then left child is only option for min
  	else if ( rc >= length )
  	    retVal = lc;
  	//have 2 children, so compare to find least 
  	else if ( data[lc] > data[rc] )
  	    retVal = lc;
  	else
  	    retVal = rc;
  	return retVal;
      }
      
      public static void swap(int[] data, int a, int b){
  	int temp = data[a];
  	data[a] = data[b];
  	data[b] = temp;
      }
  
      public static String stringify(int[] data){
  	String s = "";
  	for( int i = 0; i < data.length; i++){
  	    s+= data[i] + ", ";
  	}
  	return s;
      }
      
      public static void main(String[] args){
  	int[] data = {2,5,8,4,12,45,9,7,34,78,113,56};
  	System.out.println(stringify(sort(data)));
  
      }
  
  
  }
