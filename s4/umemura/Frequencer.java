<<<<<<< HEAD

package s4.umemura;

=======
package s4.umemura;  // ã“ã“ã¯ã€ã‹ãªã‚‰ãšã€è‡ªåˆ†ã®åå‰ã«å¤‰ãˆã‚ˆã€‚
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb
import java.lang.*;
import s4.specification.*;

/*package s4.specification;
  ‚±‚±‚ÍA‚P‰ñA‚Q‰ñ‚Æ•ÏX‚Ì‚È‚¢ŠO•”d—l‚Å‚ ‚éB
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

    int[] suffixArray; // Suffix Array‚ÌÀ‘•‚Ég‚¤ƒf[ƒ^‚ÌŒ^‚ğint []‚Æ‚¹‚æB

    // The variable, "suffixArray" is the sorted array of all suffixes of mySpace.
    // Each suffix is expressed by a integer, which is the starting position in
    // mySpace.

    // The following is the code to print the contents of suffixArray.
    // This code could be used on debugging.

    // ã“ã®é–¢æ•°ã¯ã€ãƒ‡ãƒãƒƒã‚°ã«ä½¿ã£ã¦ã‚‚ã‚ˆã„ã€‚mainã‹ã‚‰å®Ÿè¡Œã™ã‚‹ã¨ãã«ã‚‚ä½¿ã£ã¦ã‚ˆã„ã€‚
    // ãƒªãƒã‚¸ãƒˆãƒªã«pushã™ã‚‹ã¨ãã«ã¯ã€mainãƒ¡ãƒƒã‚½ãƒ‰ä»¥å¤–ã‹ã‚‰ã¯å‘¼ã°ã‚Œãªã„ã‚ˆã†ã«ã›ã‚ˆã€‚
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
        // suffixCompare‚Íƒ\[ƒg‚Ì‚½‚ß‚Ì”äŠrƒƒ\ƒbƒh‚Å‚ ‚éB
        // Ÿ‚Ì‚æ‚¤‚É’è‹`‚¹‚æB
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

        // ‚±‚±‚ÉƒR[ƒh‚ğ‹Lq‚¹‚æ
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
        // ‚±‚Ìs‚Í•ÏX‚µ‚È‚¯‚ê‚Î‚¢‚¯‚È‚¢B
=======
        // suffixCompareã¯ã‚½ãƒ¼ãƒˆã®ãŸã‚ã®æ¯”è¼ƒãƒ¡ã‚½ãƒƒãƒ‰ã§ã‚ã‚‹ã€‚
        // æ¬¡ã®ã‚ˆã†ã«å®šç¾©ã›ã‚ˆã€‚
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

        // ã“ã“ã«ã‚³ãƒ¼ãƒ‰ã‚’è¨˜è¿°ã›ã‚ˆ 
        //                                          
        return 0; // ã“ã®è¡Œã¯å¤‰æ›´ã—ãªã‘ã‚Œã°ã„ã‘ãªã„ã€‚ 
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb
    }

    public void setSpace(byte[] space) {
        // suffixArray‚Ì‘Oˆ—‚ÍAsetSpace‚Å’è‹`‚¹‚æB
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
        // ‚±‚±‚ÉAint suffixArray‚ğƒ\[ƒg‚·‚éƒR[ƒh‚ğ‘‚¯B
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
        // ‡”Ô‚ÍsuffixCompare‚Å’è‹`‚³‚ê‚é‚à‚Ì‚Æ‚·‚éB
    }

    // Suffix Array‚ğ—p‚¢‚ÄA•¶š—ñ‚Ì•p“x‚ğ‹‚ß‚éƒR[ƒh
    // ‚±‚±‚©‚çAw’è‚·‚é”ÍˆÍ‚ÌƒR[ƒh‚Í•ÏX‚µ‚Ä‚Í‚È‚ç‚È‚¢B
=======
        //                                            
        // ã“ã“ã«ã€int suffixArrayã‚’ã‚½ãƒ¼ãƒˆã™ã‚‹ã‚³ãƒ¼ãƒ‰ã‚’æ›¸ã‘ã€‚
        // ã‚‚ã—ã€mySpace ãŒ"ABC"ãªã‚‰ã°ã€
        // suffixArray = { 0, 1, 2} ã¨ãªã‚‹ã“ã¨æ±‚ã‚ã‚‰ã‚Œã‚‹ã€‚
        // ã“ã®ã¨ãã€printSuffixArrayã‚’å®Ÿè¡Œã™ã‚‹ã¨
        //   suffixArray[ 0]= 0:ABC
        //   suffixArray[ 1]= 1:BC
        //   suffixArray[ 2]= 2:C
        // ã®ã‚ˆã†ã«ãªã‚‹ã¹ãã§ã‚ã‚‹ã€‚
        // ã‚‚ã—ã€mySpace ãŒ"CBA"ãªã‚‰ã°
        // suffixArray = { 2, 1, 0} ã¨ãªã‚‹ã“ã¨ãŒæ±‚ã‚ã‚‰ã‚‹ã€‚
        // ã“ã®ã¨ãã€printSuffixArrayã‚’å®Ÿè¡Œã™ã‚‹ã¨
        //   suffixArray[ 0]= 2:A
        //   suffixArray[ 1]= 1:BA
        //   suffixArray[ 2]= 0:CBA
        // ã®ã‚ˆã†ã«ãªã‚‹ã¹ãã§ã‚ã‚‹ã€‚
    }

    // ã“ã“ã‹ã‚‰å§‹ã¾ã‚Šã€æŒ‡å®šã™ã‚‹ç¯„å›²ã¾ã§ã¯å¤‰æ›´ã—ã¦ã¯ãªã‚‰ãªã„ã‚³ãƒ¼ãƒ‰ã§ã‚ã‚‹ã€‚
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
        // æ¼”ç¿’ã®å†…å®¹ã¯ã€é©åˆ‡ãªsubByteStartIndexã¨subByteEndIndexã‚’å®šç¾©ã™ã‚‹ã“ã¨ã§ã‚ã‚‹ã€‚
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb
        int first = subByteStartIndex(start, end);
        int last1 = subByteEndIndex(start, end);
        return last1 - first;
    }
    // •ÏX‚µ‚Ä‚Í‚¢‚¯‚È‚¢ƒR[ƒh‚Í‚±‚±‚Ü‚ÅB

    private int targetCompare(int i, int j, int k) {
<<<<<<< HEAD
        // suffixArray‚ğ’Tõ‚·‚é‚Æ‚«‚Ég‚¤”äŠrŠÖ”B
        // Ÿ‚Ì‚æ‚¤‚É’è‹`‚¹‚æ
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
        // subByteStartIndexã¨subByteEndIndexã‚’å®šç¾©ã™ã‚‹ã¨ãã«ä½¿ã†æ¯”è¼ƒé–¢æ•°ã€‚
        // æ¬¡ã®ã‚ˆã†ã«å®šç¾©ã›ã‚ˆã€‚
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
        // ‚±‚±‚É”äŠr‚ÌƒR[ƒh‚ğ‘‚¯
        //

        // mySpace‚ÌƒRƒs[
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

        return 0; // ‚±‚Ìs‚Í•ÏX‚µ‚È‚¯‚ê‚Î‚È‚ç‚È‚¢B
    }

    private int subByteStartIndex(int start, int end) {
<<<<<<< HEAD
        // suffix array‚Ì‚È‚©‚ÅA–Ú“I‚Ì•¶š—ñ‚ÌoŒ»‚ªn‚Ü‚éˆÊ’u‚ğ‹‚ß‚éƒƒ\ƒbƒh
        // ˆÈ‰º‚Ì‚æ‚¤‚É’è‹`‚¹‚æB
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
        // ‚±‚±‚ÉƒR[ƒh‚ğ‹Lq‚¹‚æB
        //

        int index = 1;
        int i;
        for (i = 0; i < suffixArray.length; i++) {
            index = targetCompare(suffixArray[i], start, end);
            if (index == 0) {
                break;
            }
        }
        return i; // ‚±‚ÌƒR[ƒh‚Í•ÏX‚µ‚È‚¯‚ê‚Î‚È‚ç‚È‚¢B
    }

    private int subByteEndIndex(int start, int end) {
        // suffix array‚Ì‚È‚©‚ÅA–Ú“I‚Ì•¶š—ñ‚ÌoŒ»‚µ‚È‚­‚È‚éêŠ‚ğ‹‚ß‚éƒƒ\ƒbƒh
        // ˆÈ‰º‚Ì‚æ‚¤‚É’è‹`‚¹‚æB
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
        // ‚±‚±‚ÉƒR[ƒh‚ğ‹Lq‚¹‚æ
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
        //suffix arrayã®ãªã‹ã§ã€ç›®çš„ã®æ–‡å­—åˆ—ã®å‡ºç¾ãŒå§‹ã¾ã‚‹ä½ç½®ã‚’æ±‚ã‚ã‚‹ãƒ¡ã‚½ãƒƒãƒ‰
        // ä»¥ä¸‹ã®ã‚ˆã†ã«å®šç¾©ã›ã‚ˆã€‚
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
        // ã“ã“ã«ã‚³ãƒ¼ãƒ‰ã‚’è¨˜è¿°ã›ã‚ˆã€‚                                                 
        //                                                                         
        return suffixArray.length; //ã“ã®ã‚³ãƒ¼ãƒ‰ã¯å¤‰æ›´ã—ãªã‘ã‚Œã°ãªã‚‰ãªã„ã€‚          
    }

    private int subByteEndIndex(int start, int end) {
        //suffix arrayã®ãªã‹ã§ã€ç›®çš„ã®æ–‡å­—åˆ—ã®å‡ºç¾ã—ãªããªã‚‹å ´æ‰€ã‚’æ±‚ã‚ã‚‹ãƒ¡ã‚½ãƒƒãƒ‰
        // ä»¥ä¸‹ã®ã‚ˆã†ã«å®šç¾©ã›ã‚ˆã€‚
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
        //ã€€ã“ã“ã«ã‚³ãƒ¼ãƒ‰ã‚’è¨˜è¿°ã›ã‚ˆ                                           
        //                                                                   
        return suffixArray.length; // ã“ã®è¡Œã¯å¤‰æ›´ã—ãªã‘ã‚Œã°ãªã‚‰ãªã„ã€       
    }
>>>>>>> 77c75f48abb2080105253f1c5c74c26e2683c0fb

        return i; // ‚±‚ÌƒR[ƒh‚Í•ÏX‚µ‚È‚¯‚ê‚Î‚È‚ç‚È‚¢B
    }

    // Suffix Array‚ğg‚Á‚½ƒvƒƒOƒ‰ƒ€‚ÌƒzƒƒCƒgƒeƒXƒg‚ÍA
    // private‚Èƒƒ\ƒbƒh‚ÆƒtƒB[ƒ‹ƒh‚ğƒAƒNƒZƒX‚·‚é‚±‚Æ‚ª•K—v‚È‚Ì‚ÅA
    // ƒNƒ‰ƒX‚É‘®‚·‚éstatic main‚É‘‚­•û–@‚à‚ ‚éB
    // static main‚ª‚ ‚Á‚Ä‚àAŒÄ‚Ñ‚¾‚³‚È‚¯‚ê‚Î‚æ‚¢B
    // ˆÈ‰º‚ÍA©—R‚É•ÏX‚µ‚ÄÀŒ±‚·‚é‚±‚ÆB
    // ’ˆÓF•W€o—ÍAƒGƒ‰[o—Í‚ÉƒƒbƒZ[ƒW‚ğo‚·‚±‚Æ‚ÍA
    // static main‚©‚ç‚ÌÀs‚Ì‚Æ‚«‚¾‚¯‚É‹–‚³‚ê‚éB
    // ŠO•”‚©‚çFrequencer‚ğg‚¤‚Æ‚«‚ÉƒƒbƒZ[ƒW‚ğo—Í‚µ‚Ä‚Í‚È‚ç‚È‚¢B
    // ‹³ˆõ‚ÌƒeƒXƒgÀs‚Ì‚Æ‚«‚ÉƒƒbƒZ[ƒW‚ª‚Å‚é‚ÆAd—l‚É‚È‚¢“®ì‚ğ‚·‚é‚Æ‚İ‚È‚µA
    // Œ¸“_‚Ì‘ÎÛ‚Å‚ ‚éB
    public static void main(String[] args) {
        Frequencer frequencerObject;
        try { // ãƒ†ã‚¹ãƒˆã«ä½¿ã†ã®ã«æ¨å¥¨ã™ã‚‹mySpaceã®æ–‡å­—ã¯ã€"ABC", "CBA", "HHH", "Hi Ho Hi Ho".
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
