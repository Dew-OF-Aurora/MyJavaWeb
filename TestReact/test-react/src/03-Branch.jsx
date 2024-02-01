const type = num => {
  if (num === 1) {
    return <div>返回1</div>;
  } else {
    return <div>返回2</div>;
  }
};
function Branch() {
  return <div className="App">{type(1)}</div>;
}
export default Branch;
