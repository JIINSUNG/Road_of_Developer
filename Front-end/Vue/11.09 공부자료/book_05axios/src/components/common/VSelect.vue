<script setup>
import { ref } from 'vue'

defineProps({
  selectOptions: {
    type: Array
  }
  // selectValue: {
  //   type: String,
  //   required: true,
  // },
  // selectLabel: {
  //   type: String,
  //   required: true,
  // },
})

const emit = defineEmits(['onKeySelect'])

const key = ref('all')
const onSelect = () => {
  console.log(key.value + '선택!!')
  emit('onKeySelect', key.value)
}
</script>

<template>
  <select
    v-model="key"
    @change="onSelect"
    class="form-select form-select-sm ms-5 me-1 w-50"
    aria-label="검색조건"
  >
    <option
      v-for="option in selectOptions"
      :value="option.value"
      :key="option.value"
      :disabled="option.value === ''"
    >
      {{ option.text }}
    </option>

    <!-- <option selected>검색조건</option>
    <option value="articleno">글번호</option>
    <option value="subject">제목</option>
    <option value="userid">작성자</option> -->
  </select>
</template>

<style scoped></style>
