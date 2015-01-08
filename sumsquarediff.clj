(defn sumall
  [n]
  (if (= n ())
    0
    (+ (first n) (sumall (rest n)))))

(defn trsumall [n]
  ((fn rsum [remaining acc]
    (if (= remaining ())
      acc
      (rsum (rest remaining) (+ acc (first remaining)))))
  n 0))

(defn sumofsquares [n]
  (trsumall (map #(* % %) (range (+ n 1)))))

(defn squareofsum [n]
  (def sum (trsumall (range (+ 1 n))))
  (* sum sum))


(println (- (squareofsum 100) (sumofsquares 100)))

