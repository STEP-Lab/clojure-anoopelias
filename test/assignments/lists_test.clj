(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3])))))
  (testing "map"
    (testing "identity with single coll"
      (is (= [3 4 5] (map' (comp inc inc) [1 2 3]))))))