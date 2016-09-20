package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._
import Math.min

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    n <- arbitrary[A]
    h <- frequency((1, Gen.const(empty)), (9, genHeap))
  } yield insert(n, h)
  
  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }
  
  property("smallest of 2 should be smallest in a heap that only containing the 2") = forAll {
    (n1: A, n2:A) => 
      val h = insert(n1, insert(n2, empty))
      findMin(h) == min(n1, n2)
  }
  
  property("Deleting the minimum value should empty the heap") = forAll {
    (n: A) => isEmpty(deleteMin(insert(n, empty)))
  }
  
  property("Heap is sorted if deleting min from heap results in heap whose min is greater") =
     forAll { (h: H) => {
      def isSorted(h: H): Boolean = {
        if (isEmpty(h)) true
        else {
          val m = findMin(h)
          val h2 = deleteMin(h)
          isEmpty(h) || (m <= findMin(h2) && isSorted(h2))
        }
      }
      isSorted(h)
    }
  }
  
  property("min of two melded heaps should be min of min of both heaps") = forAll {
    (h1: H, h2: H) => findMin(meld(h1, h2)) == min(findMin(h1), findMin(h2))
  }
  
  property("Two heaps are equal if recursively removing min element from each equals") = forAll {
    (h1: H, h2: H) => {
      def heapEqual(h1: H, h2: H): Boolean = {
        if (isEmpty(h1) && isEmpty(h2)) true
        else {
          val m1 = findMin(h1)
          val m2 = findMin(h2)
          m1 == m2 && heapEqual(deleteMin(h1), deleteMin(h2))
        }
      }
      heapEqual(meld(h1, h2), meld(deleteMin(h1), insert(findMin(h1), h2)))
    }
  }
  
  property("min of two heaps should be same even after displacing min of either heap with it") = forAll {
    (h1: H, h2: H) => {
      val m1 = findMin(h1)
      val m2 = findMin(h2)
      val m = min(m1, m2)
      findMin(meld(deleteMin(h1), insert(m, h2))) == m
    }
  }
  
  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)
}
