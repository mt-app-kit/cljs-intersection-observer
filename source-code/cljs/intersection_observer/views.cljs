
(ns intersection-observer.views
    (:require [reagent.core]
              [intersection-observer.side-effects :as side-effects]
              [react-references.api :as react-references]
              [fruits.random.api :as random]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn sensor
  ; @description
  ; Intersection sensor component that automatically ...
  ; ... sets up an intersection observer when mounts,
  ; ... removes the intersection observer when unmounts.
  ;
  ; @param (keyword)(opt) observer-id
  ; @param (map) observer-props
  ; {:callback-f (function)}
  ;
  ; @usage
  ; [sensor {...)}]
  ;
  ; @usage
  ; [sensor :my-observer {...}]
  ;
  ; @usage
  ; [sensor :my-observer {:callback-f (fn [intersect?] ...)}]
  ([observer-props]
   [sensor (random/generate-keyword) observer-props])

  ([observer-id {:keys [callback-f]}]
   (reagent.core/create-class {:component-did-mount    (fn [_ _] (side-effects/setup-observer!  observer-id {:get-element-f react-references/get-reference :callback-f callback-f}))
                               :component-will-unmount (fn [_ _] (side-effects/remove-observer! observer-id {:get-element-f react-references/get-reference}))
                               :reagent-render         (fn [_ _] [:div {:class (-> :intersection-observer--sensor)
                                                                        :ref   (-> observer-id react-references/set-reference-f)}])})))
