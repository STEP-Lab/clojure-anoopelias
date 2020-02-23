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