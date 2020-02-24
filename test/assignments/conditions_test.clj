(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 3 0)))))

(deftest harishchandran
  (testing "truethy values"
    (is (= 2 (harishchandra 2))))
  (testing "true itself"
    (is (= true (harishchandra (= 2 2)))))
  (testing "false"
    (is (= nil (harishchandra (= 2 3)))))
  (testing "falsey values"
    (is (= nil (harishchandra nil)))))

(deftest yudishtiran
  (testing "truethy values"
    (is (= 2 (yudishtira 2))))
  (testing "true itself"
    (is (= true (yudishtira (= 2 2)))))
  (testing "false"
    (is (= :aswathama (yudishtira (= 2 3)))))
  (testing "falsey values"
    (is (= :aswathama (yudishtira nil)))))

(deftest duplicated-first
  (testing "list"
    (is (= [1 1 2] (duplicate-first [1 2]))))
  (testing "empty list"
    (is (= nil (duplicate-first [])))))

(deftest test-five-point-someone
  (testing "chetan"
    (is (= :chetan-bhagat (five-point-someone 1 5))))
  (testing "still chetan"
    (is (= :chetan-bhagat (five-point-someone 5 5))))
  (testing "satan"
    (is (= :satan-bhagat (five-point-someone 5 1))))
  (testing "still satan"
    (is (= :satan-bhagat (five-point-someone 5 9))))
  (testing "greece"
    (is (= :greece (five-point-someone 6 1))))
  (testing "universe"
    (is (= :universe (five-point-someone 1 6)))))

(deftest conditions-applied
  (testing "wonder-woman"
    (is (= :wonder-woman (conditions-apply [1 2 1 3]))))
  (testing "no match"
    (is (= :tuntun (conditions-apply [1 2 1 4 :a :b :d [4 5] [2 3]]))))
  (testing "multiple (1 3), no wonder-woman"
    (is (= :tuntun (conditions-apply [1 3 1 3]))))
  (testing "wonder-woman before anyone else"
    (is (= :wonder-woman (conditions-apply [:a :b :c [2 3] [4 5] 1 3]))))
  (testing "durga"
    (is (= :durga (conditions-apply [:a :b :c :d :e :f]))))
  (testing "cleopatra"
    (is (= :cleopatra (conditions-apply [[2 3] [4 5]])))))

(deftest repeated-and-truncated
  (testing "repeat and truncate"
    (is (= '(0 1 2 3 0 1) (repeat-and-truncate (range 4) true true 6))))
  (testing "repeat only"
    (is (= '(0 1 2 0 1 2) (repeat-and-truncate (range 3) true false 6))))
  (testing "truncate only"
    (is (= '(0 1 2) (repeat-and-truncate (range 10) false true 3))))
  (testing "nothing"
    (is (= '(0 1 2) (repeat-and-truncate (range 3) false false 3)))))

(deftest ordered-in-words
  (testing "x > y"
    (is (= [:x-greater-than-y] (order-in-words 6 3 5))))
  (testing "y > z"
    (is (= [:y-greater-than-z] (order-in-words 6 7 5))))
  (testing "z > x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4))))
  (testing "x > y and y > z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "x > y and z > x"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5)))))
