(defn merge-step
  ([left right]
   (merge-step (list left right)))
  ([[left right]]
   (loop [l left, r right, result []]
     (let [lhead (first l), rhead (first r)]
       (cond
             (nil? lhead) (concat result r)
             (nil? rhead) (concat result l)
             (<= lhead rhead) (recur (rest l) r (conj result lhead))
             true (recur l (rest r) (conj result rhead)))))))

(defn mergesort

  [xs]
  ((fn mergesort-counted [xs n]
     (if (<= n 1)
       xs
       (let [middle (bit-shift-right n 1)]
         (merge-step (map mergesort-counted
                          (split-at middle xs)
                          [middle (- n middle) ] )))))
   xs (count xs)))

(def a (list 1 2 8 3 44 7 3 7 9))



(defn mrg [[x & xrest :as X] [y & yrest :as Y] R]
  (if (and (not-empty X) (not-empty Y))
    (if (<= x y)
      (mrg xrest Y (conj R x))
      (mrg X yrest (conj R y)))
    (concat R X Y)))

(defn mrgst [X]
  (if (> (count X) 1)
    (let [sides (split-at (bit-shift-right (count X) 1) X)]
      (mrg (mrgst (get sides 0)) (mrgst (get sides 1)) []))
    X ))

(def a (shuffle (range 1000)))
(def b (shuffle (range 10000000)))

(time (mrgst (shuffle a)))
(time (mergesort (shuffle b)))
