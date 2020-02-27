(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "inc with single coll"
      (is (= [3 4 5] (map' (comp inc inc) [1 2 3]))))
    (testing "vector with multiple coll"
      (is (= [[1 4] [2 5] [3 6]] (map' vector [1 2 3] [4 5 6]))))
    (testing "vector with multiple multisized coll"
      (is (= [[1 4] [2 5]] (map' vector [1 2 3] [4 5]))))))