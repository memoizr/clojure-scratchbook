(defn fact [x]
  (loop [n x acc 1]
    (if (= n 1) acc
      (recur (dec n) (*' acc n)))))

(defn lattice-paths [m n]
  (/ (fact (+ m n)) (*' (fact m) (fact n))))

(println (lattice-paths 2 2))
(println (lattice-paths 3 3))
(println (lattice-paths 4 4))
(println (lattice-paths 5 5))
(println (lattice-paths 20 20))
