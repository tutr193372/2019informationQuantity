<<<<<<< HEAD

package s4.umemura;

=======
package s4.umemura;  // ここは、かならず、自分の名前に変えよ。
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb
import java.lang.*;
import s4.specification.*;

/*package s4.specification;
  �����́A�P��A�Q��ƕύX�̂Ȃ��O���d�l�ł���B
  public interface FrequencerInterface {     // This interface provides the design for frequency counter.
  void setTarget(byte  target[]); // set the data to search.
  void setSpace(byte  space[]);  // set the data to be searched target from.
  int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
  //Otherwise, it return 0, when SPACE is not set or SPACE's length is zero
  //Otherwise, get the frequency of TAGET in SPACE
  int subByteFrequency(int start, int end);
  // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
  // For the incorrect value of START or END, the behavior is undefined.
  }
*/

public class Frequencer implements FrequencerInterface {
    // Code to start with: This code is not working, but good start point to work.
    byte[] myTarget;
    byte[] mySpace;
    boolean targetReady = false;
    boolean spaceReady = false;

    int[] suffixArray; // Suffix Array�̎����Ɏg���f�[�^�̌^��int []�Ƃ���B

    // The variable, "suffixArray" is the sorted array of all suffixes of mySpace.
    // Each suffix is expressed by a integer, which is the starting position in
    // mySpace.

    // The following is the code to print the contents of suffixArray.
    // This code could be used on debugging.

    // この関数は、デバッグに使ってもよい。mainから実行するときにも使ってよい。
    // リポジトリにpushするときには、mainメッソド以外からは呼ばれないようにせよ。
    //
    private void printSuffixArray() {
        if (spaceReady) {
            for (int i = 0; i < mySpace.length; i++) {
                int s = suffixArray[i];
<<<<<<< HEAD
                for (int j = s; j < mySpace.length; j++) {
=======
                System.out.printf("suffixArray[%2d]=%2d:", i, s);
                for(int j=s;j<mySpace.length;j++) {
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb
                    System.out.write(mySpace[j]);
                }
                System.out.write('\n');
            }
        }
    }

    private int suffixCompare(int i, int j) {
<<<<<<< HEAD
        // suffixCompare�̓\�[�g�̂��߂̔�r���\�b�h�ł���B
        // ���̂悤�ɒ�`����B
        // comparing two suffixes by dictionary order.
        // suffix_i is a string starting with the position i in "byte [] mySpace".
        // Each i and j denote suffix_i, and suffix_j.
        // Example of dictionary order
        // "i" < "o" : compare by code
        // "Hi" < "Ho" ; if head is same, compare the next element
        // "Ho" < "Ho " ; if the prefix is identical, longer string is big
        //
        // The return value of "int suffixCompare" is as follows.
        // if suffix_i > suffix_j, it returns 1
        // if suffix_i < suffix_j, it returns -1
        // if suffix_i = suffix_j, it returns 0;

        // �����ɃR�[�h���L�q����
        byte[] suffix_i_byte = new byte[mySpace.length - i];
        int tmp = 0;
        for (int a = i; a < mySpace.length; a++) {
            suffix_i_byte[tmp] = mySpace[a];
            tmp++;
        }
        tmp = 0;
        byte[] suffix_j_byte = new byte[mySpace.length - j];
        for (int a = j; a < mySpace.length; a++) {
            suffix_j_byte[tmp] = mySpace[a];
            tmp++;
        }

        String suffix_i = new String(suffix_i_byte);
        String suffix_j = new String(suffix_j_byte);

        if (suffix_i.compareTo(suffix_j) > 0) {
            return 1;
        } else if (suffix_i.compareTo(suffix_j) < 0) {
            return -1;
        } else {
            return 0;
        }

        //
        // ���̍s�͕ύX���Ȃ���΂����Ȃ��B
=======
        // suffixCompareはソートのための比較メソッドである。
        // 次のように定義せよ。
        //
        // comparing two suffixes by dictionary order.
        // suffix_i is a string starting with the position i in "byte [] mySpace".
        // When mySpace is "ABCD", suffix_0 is "ABCD", suffix_1 is "BCD", 
        // suffix_2 is "CD", and sufffix_3 is "D".
        // Each i and j denote suffix_i, and suffix_j.                            
        // Example of dictionary order                                            
        // "i"      <  "o"        : compare by code                              
        // "Hi"     <  "Ho"       ; if head is same, compare the next element    
        // "Ho"     <  "Ho "      ; if the prefix is identical, longer string is big  
        //  
        //The return value of "int suffixCompare" is as follows. 
        // if suffix_i > suffix_j, it returns 1   
        // if suffix_i < suffix_j, it returns -1  
        // if suffix_i = suffix_j, it returns 0;   

        // ここにコードを記述せよ 
        //                                          
        return 0; // この行は変更しなければいけない。 
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb
    }

    public void setSpace(byte[] space) {
        // suffixArray�̑O�����́AsetSpace�Œ�`����B
        mySpace = space;
        if (mySpace.length > 0)
            spaceReady = true;
        // First, create unsorted suffix array.
        suffixArray = new int[space.length];
        // put all suffixes in suffixArray.
        for (int i = 0; i < space.length; i++) {
            suffixArray[i] = i; // Please note that each suffix is expressed by one integer.
        }
        //
        // �����ɁAint suffixArray���\�[�g����R�[�h�������B
        for (int i = 0; i < suffixArray.length - 1; i++) {
            for (int j = suffixArray.length - 1; j > i; j--) {
                if (suffixCompare(suffixArray[j - 1], suffixArray[j]) == 1) {
                    int tmp = suffixArray[j - 1];
                    suffixArray[j - 1] = suffixArray[j];
                    suffixArray[j] = tmp;
                }
            }
        }
<<<<<<< HEAD
        // ���Ԃ�suffixCompare�Œ�`�������̂Ƃ���B
    }

    // Suffix Array��p���āA������̕p�x�����߂�R�[�h
    // ��������A�w�肷��͈͂̃R�[�h�͕ύX���Ă͂Ȃ�Ȃ��B
=======
        //                                            
        // ここに、int suffixArrayをソートするコードを書け。
        // もし、mySpace が"ABC"ならば、
        // suffixArray = { 0, 1, 2} となること求められる。
        // このとき、printSuffixArrayを実行すると
        //   suffixArray[ 0]= 0:ABC
        //   suffixArray[ 1]= 1:BC
        //   suffixArray[ 2]= 2:C
        // のようになるべきである。
        // もし、mySpace が"CBA"ならば
        // suffixArray = { 2, 1, 0} となることが求めらる。
        // このとき、printSuffixArrayを実行すると
        //   suffixArray[ 0]= 2:A
        //   suffixArray[ 1]= 1:BA
        //   suffixArray[ 2]= 0:CBA
        // のようになるべきである。
    }

    // ここから始まり、指定する範囲までは変更してはならないコードである。
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb

    public void setTarget(byte[] target) {
        myTarget = target;
        if (myTarget.length > 0)
            targetReady = true;
    }

    public int frequency() {
        if (targetReady == false)
            return -1;
        if (spaceReady == false)
            return 0;
        return subByteFrequency(0, myTarget.length);
    }

    public int subByteFrequency(int start, int end) {
<<<<<<< HEAD
        /*
         * This method be work as follows, but much more efficient int spaceLength =
         * mySpace.length; int count = 0; for(int offset = 0; offset< spaceLength - (end
         * - start); offset++) { boolean abort = false; for(int i = 0; i< (end - start);
         * i++) { if(myTarget[start+i] != mySpace[offset+i]) { abort = true; break; } }
         * if(abort == false) { count++; } }
         */
=======
        // start, and end specify a string to search in myTarget,
        // if myTarget is "ABCD", 
        //     start=0, and end=1 means string "A".
        //     start=1, and end=3 means string "BC".
        // This method returns how many the string appears in my Space.
        // 
        /* This method should be work as follows, but much more efficient.
           int spaceLength = mySpace.length;                      
           int count = 0;                                        
           for(int offset = 0; offset< spaceLength - (end - start); offset++) {
            boolean abort = false; 
            for(int i = 0; i< (end - start); i++) {
             if(myTarget[start+i] != mySpace[offset+i]) { abort = true; break; }
            }
            if(abort == false) { count++; }
           }
        */
        // The following the counting method using suffix array.
        // 演習の内容は、適切なsubByteStartIndexとsubByteEndIndexを定義することである。
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb
        int first = subByteStartIndex(start, end);
        int last1 = subByteEndIndex(start, end);
        return last1 - first;
    }
    // �ύX���Ă͂����Ȃ��R�[�h�͂����܂ŁB

    private int targetCompare(int i, int j, int k) {
<<<<<<< HEAD
        // suffixArray��T������Ƃ��Ɏg����r�֐��B
        // ���̂悤�ɒ�`����
        // suffix_i is a string in mySpace starting at i-th position.
        // target_i_k is a string in myTarget start at j-th postion ending k-th
        // position.
        // comparing suffix_i and target_j_k.
        // if the beginning of suffix_i matches target_i_k, it return 0.
        // The behavior is different from suffixCompare on this case.
        // if suffix_i > target_i_k it return 1;
        // if suffix_i < target_i_k it return -1;
        // It should be used to search the appropriate index of some suffix.
        // Example of search
        // suffix target
        // "o" > "i"
        // "o" < "z"
        // "o" = "o"
        // "o" < "oo"
        // "Ho" > "Hi"
        // "Ho" < "Hz"
        // "Ho" = "Ho"
        // "Ho" < "Ho " : "Ho " is not in the head of suffix "Ho"
        // "Ho" = "H" : "H" is in the head of suffix "Ho"
=======
        // subByteStartIndexとsubByteEndIndexを定義するときに使う比較関数。
        // 次のように定義せよ。
        // suffix_i is a string starting with the position i in "byte [] mySpace".
        // When mySpace is "ABCD", suffix_0 is "ABCD", suffix_1 is "BCD", 
        // suffix_2 is "CD", and sufffix_3 is "D".
        // target_j_k is a string in myTarget start at j-th postion ending k-th position.
        // if myTarget is "ABCD", 
        //     j=0, and k=1 means that target_j_k is "A".
        //     j=1, and k=3 means that target_j_k is "BC".
        // This method compares suffix_i and target_j_k.
        // if the beginning of suffix_i matches target_j_k, it return 0.
        // if suffix_i > target_j_k it return 1; 
        // if suffix_i < target_j_k it return -1;
        // if first part of suffix_i is equal to target_j_k, it returns 0;
        //
        // Example of search 
        // suffix          target
        // "o"       >     "i"
        // "o"       <     "z"
        // "o"       =     "o"
        // "o"       <     "oo"
        // "Ho"      >     "Hi"
        // "Ho"      <     "Hz"
        // "Ho"      =     "Ho"
        // "Ho"      <     "Ho "   : "Ho " is not in the head of suffix "Ho"
        // "Ho"      =     "H"     : "H" is in the head of suffix "Ho"
        // The behavior is different from suffixCompare on this case.
        // For example,
        //    if suffix_i is "Ho Hi Ho", and target_j_k is "Ho", 
        //            targetCompare should return 0;
        //    if suffix_i is "Ho Hi Ho", and suffix_j is "Ho", 
        //            suffixCompare should return -1.
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb
        //
        // �����ɔ�r�̃R�[�h������
        //

        // mySpace�̃R�s�[
        byte[] _mySpace = new byte[mySpace.length];
        for (int a = 0; a < mySpace.length - 1; a++) {
            _mySpace[a] = mySpace[a];
        }

        byte[] suffix_i = new byte[mySpace.length - i];
        for (int a = i; a < mySpace.length; a++) {
            suffix_i[a - i] = mySpace[a];
        }

        for (int a = 0; a < k; a++) {
            if (suffix_i[a] > myTarget[a]) {
                return 1;
            } else if (suffix_i[a] < myTarget[a]) {
                return -1;
            }
        }

        return 0; // ���̍s�͕ύX���Ȃ���΂Ȃ�Ȃ��B
    }

    private int subByteStartIndex(int start, int end) {
<<<<<<< HEAD
        // suffix array�̂Ȃ��ŁA�ړI�̕�����̏o�����n�܂�ʒu�����߂郁�\�b�h
        // �ȉ��̂悤�ɒ�`����B
        /*
         * Example of suffix created from "Hi Ho Hi Ho" 0: Hi Ho 1: Ho 2: Ho Hi Ho 3:Hi
         * Ho 4:Hi Ho Hi Ho 5:Ho 6:Ho Hi Ho 7:i Ho 8:i Ho Hi Ho 9:o A:o Hi Ho
         */

        // It returns the index of the first suffix
        // which is equal or greater than target_start_end.
        // Assuming the suffix array is created from "Hi Ho Hi Ho",
        // if target_start_end is "Ho", it will return 5.
        // Assuming the suffix array is created from "Hi Ho Hi Ho",
        // if target_start_end is "Ho ", it will return 6.
        //
        // �����ɃR�[�h���L�q����B
        //

        int index = 1;
        int i;
        for (i = 0; i < suffixArray.length; i++) {
            index = targetCompare(suffixArray[i], start, end);
            if (index == 0) {
                break;
            }
        }
        return i; // ���̃R�[�h�͕ύX���Ȃ���΂Ȃ�Ȃ��B
    }

    private int subByteEndIndex(int start, int end) {
        // suffix array�̂Ȃ��ŁA�ړI�̕�����̏o�����Ȃ��Ȃ�ꏊ�����߂郁�\�b�h
        // �ȉ��̂悤�ɒ�`����B
        /*
         * Example of suffix created from "Hi Ho Hi Ho" 0: Hi Ho 1: Ho 2: Ho Hi Ho 3:Hi
         * Ho 4:Hi Ho Hi Ho 5:Ho 6:Ho Hi Ho 7:i Ho 8:i Ho Hi Ho 9:o A:o Hi Ho
         */
        // It returns the index of the first suffix
        // which is greater than target_start_end; (and not equal to target_start_end)
        // Assuming the suffix array is created from "Hi Ho Hi Ho",
        // if target_start_end is "Ho", it will return 7 for "Hi Ho Hi Ho".
        // Assuming the suffix array is created from "Hi Ho Hi Ho",
        // if target_start_end is"i", it will return 9 for "Hi Ho Hi Ho".
        //
        // �����ɃR�[�h���L�q����
        //
        int index = 1, index_before = 1;
        int i;
        for (i = 0; i < suffixArray.length; i++) {
            index_before = index;
            index = targetCompare(suffixArray[i], start, end);
            if (index != 0 && index_before == 0) {
                break;
            }
        }
=======
        //suffix arrayのなかで、目的の文字列の出現が始まる位置を求めるメソッド
        // 以下のように定義せよ。
        // The meaning of start and end is the same as subByteFrequency.
        /* Example of suffix created from "Hi Ho Hi Ho"
           0: Hi Ho
           1: Ho
           2: Ho Hi Ho
           3:Hi Ho
           4:Hi Ho Hi Ho
           5:Ho
           6:Ho Hi Ho
           7:i Ho
           8:i Ho Hi Ho
           9:o
          10:o Hi Ho
        */

        // It returns the index of the first suffix 
        // which is equal or greater than target_start_end.                         
	// Suppose target is set "Ho Ho Ho Ho"
        // if start = 0, and end = 2, target_start_end is "Ho".
        // if start = 0, and end = 3, target_start_end is "Ho ".
        // Assuming the suffix array is created from "Hi Ho Hi Ho",                 
        // if target_start_end is "Ho", it will return 5.                           
        // Assuming the suffix array is created from "Hi Ho Hi Ho",                 
        // if target_start_end is "Ho ", it will return 6.                
        //                                                                          
        // ここにコードを記述せよ。                                                 
        //                                                                         
        return suffixArray.length; //このコードは変更しなければならない。          
    }

    private int subByteEndIndex(int start, int end) {
        //suffix arrayのなかで、目的の文字列の出現しなくなる場所を求めるメソッド
        // 以下のように定義せよ。
        // The meaning of start and end is the same as subByteFrequency.
        /* Example of suffix created from "Hi Ho Hi Ho"
           0: Hi Ho                                    
           1: Ho                                       
           2: Ho Hi Ho                                 
           3:Hi Ho                                     
           4:Hi Ho Hi Ho                              
           5:Ho                                      
           6:Ho Hi Ho                                
           7:i Ho                                    
           8:i Ho Hi Ho                              
           9:o                                       
          10:o Hi Ho                                 
        */
        // It returns the index of the first suffix 
        // which is greater than target_start_end; (and not equal to target_start_end)
	// Suppose target is set "High_and_Low",
        // if start = 0, and end = 2, target_start_end is "Hi".
        // if start = 1, and end = 2, target_start_end is "i".
        // Assuming the suffix array is created from "Hi Ho Hi Ho",                   
        // if target_start_end is "Ho", it will return 7 for "Hi Ho Hi Ho".  
        // Assuming the suffix array is created from "Hi Ho Hi Ho",          
        // if target_start_end is"i", it will return 9 for "Hi Ho Hi Ho".    
        //                                                                   
        //　ここにコードを記述せよ                                           
        //                                                                   
        return suffixArray.length; // この行は変更しなければならない、       
    }
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb

        return i; // ���̃R�[�h�͕ύX���Ȃ���΂Ȃ�Ȃ��B
    }

    // Suffix Array���g�����v���O�����̃z���C�g�e�X�g�́A
    // private�ȃ��\�b�h�ƃt�B�[���h���A�N�Z�X���邱�Ƃ��K�v�Ȃ̂ŁA
    // �N���X�ɑ�����static main�ɏ������@������B
    // static main�������Ă��A�Ăт����Ȃ���΂悢�B
    // �ȉ��́A���R�ɕύX���Ď������邱�ƁB
    // ���ӁF�W���o�́A�G���[�o�͂Ƀ��b�Z�[�W���o�����Ƃ́A
    // static main����̎��s�̂Ƃ������ɋ������B
    // �O������Frequencer���g���Ƃ��Ƀ��b�Z�[�W���o�͂��Ă͂Ȃ�Ȃ��B
    // �����̃e�X�g���s�̂Ƃ��Ƀ��b�Z�[�W���ł�ƁA�d�l�ɂȂ����������Ƃ݂Ȃ��A
    // ���_�̑Ώۂł���B
    public static void main(String[] args) {
        Frequencer frequencerObject;
        try { // テストに使うのに推奨するmySpaceの文字は、"ABC", "CBA", "HHH", "Hi Ho Hi Ho".
            frequencerObject = new Frequencer();
            frequencerObject.setSpace("ABC".getBytes());
            frequencerObject.printSuffixArray();
            frequencerObject = new Frequencer();
            frequencerObject.setSpace("CBA".getBytes());
            frequencerObject.printSuffixArray();
            frequencerObject = new Frequencer();
            frequencerObject.setSpace("HHH".getBytes());
            frequencerObject.printSuffixArray();
            frequencerObject = new Frequencer();
            frequencerObject.setSpace("Hi Ho Hi Ho".getBytes());
<<<<<<< HEAD
            frequencerObject.printSuffixArray(); // you may use this line for DEBUG
            /*
             * Example from "Hi Ho Hi Ho" 0: Hi Ho 1: Ho 2: Ho Hi Ho 3:Hi Ho 4:Hi Ho Hi Ho
             * 5:Ho 6:Ho Hi Ho 7:i Ho 8:i Ho Hi Ho 9:o A:o Hi Ho
             */
=======
            frequencerObject.printSuffixArray();
            /* Example from "Hi Ho Hi Ho"    
               0: Hi Ho                      
               1: Ho                         
               2: Ho Hi Ho                   
               3:Hi Ho                       
               4:Hi Ho Hi Ho                 
               5:Ho                          
               6:Ho Hi Ho
               7:i Ho                        
               8:i Ho Hi Ho                  
               9:o                           
              10:o Hi Ho                     
            */
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb

            frequencerObject.setTarget("H".getBytes());
            //
            // **** Please write code to check subByteStartIndex, and subByteEndIndex
            //

            int result = frequencerObject.frequency();
            System.out.print("Freq = " + result + " ");
            if (4 == result) {
                System.out.println("OK");
            } else {
                System.out.println("WRONG");
            }
        } catch (Exception e) {
            System.out.println("STOP");
        }
    }
}
