(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))


(defn set-of? [x y]
  "Checks if two collections x and y contains same set
  of elements in no particular order"
  (let [x (set x)
        y (set y)]
    (= (count x)
       (count y)
       (count (filter x y)))))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "inc with single coll"
      (is (= [3 4 5] (map' (comp inc inc) [1 2 3]))))
    (testing "vector with multiple coll"
      (is (= [[1 4] [2 5] [3 6]] (map' vector [1 2 3] [4 5 6]))))
    (testing "vector with multiple multisized coll"
      (is (= [[1 4] [2 5]] (map' vector [1 2 3] [4 5])))))

  (testing "filter"
    (testing "filter even numbers"
      (is (= [2 4 6] (filter' even? [1 2 3 4 5 6 7]))))
    (testing "filter by identity"
      (is (= [1 2 4 4 5] (filter' identity [1 2 nil 4 nil 4 5]))))
    (testing "filter empty vector"
      (is (= [] (filter' identity [])))))

  (testing "reduce"
    (testing "with first arg"
      (testing "join"
        (is (= ":, 1, 2, 3, 4" (reduce' #(str %1 ", " %2) ":" [1 2 3 4]))))
      (testing "join one element"
        (is (= ":, 1" (reduce' #(str %1 ", " %2) ":" [1]))))
      (testing "join empty"
        (is (= ":" (reduce' #(str %1 ", " %2) ":" [])))))
    (testing "without first arg"
      (testing "sum"
        (is (= 10 (reduce' + [1 2 3 4])))))
      (testing "sum one element"
        (is (= 1 (reduce' + [1]))))
      (testing "sum no elements"
        (is (= 0 (reduce' + [])))))

  (testing "count"
    (testing "count 2 elements"
      (is (= 2 (count' [1 3]))))
    (testing "count 1 element"
      (is (= 1 (count' [1]))))
    (testing "count no elements"
      (is (= 0 (count' [])))))

  (testing "reverse"
    (testing "reverse a list"
      (is (= [3 1] (reverse' '(1 3)))))
    (testing "reverse a vector"
      (is (= [6 3 1] (reverse' [1 3 6]))))
    (testing "try reversing something other than a collection"
      (is (= nil (reverse' 1))))
    (testing "reverse a set"
      (is (set-of? #{1 5 3} (reverse #{1 5 3}))))
    (testing "reverse a map"
      (is (set-of? #{[1 5] [4 6]} (reverse {1 5 4 6})))))

  (testing "every"
    (testing "every number is even"
      (is (= true (every?' even? '(2 4)))))
    (testing "at least one number is not even"
      (is (= false (every?' even? '(2 5 4))))))

  (testing "some"
    (testing "some number is even"
      (is (= true (some?' even? '(1 4 9)))))
    (testing "no number is even"
      (is (= false (some?' even? '(1 3 9))))))

  (testing "ascending"
    (testing "ascending sequence"
      (is (= true (ascending? '(1 4 9))))
    (testing "non ascending sequence"
      (is (= false (ascending? '(4 1 9))))))))